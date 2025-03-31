package com.uendel.tests;

import com.uendel.core.BaseTest;
import com.uendel.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Login com credenciais inválidas deve exibir mensagem de erro")
    @Tag("screenshotOnFail")
    public void testLoginInvalido() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLogin();
        loginPage.login("email@invalido.com", "senhaerrada");

        String mensagemErro = loginPage.getErrorMessage();
        assertTrue(mensagemErro.contains("Your email or password is incorrect!"),
                   "A mensagem de erro deve ser exibida.");
    }

    @Test
    @DisplayName("Login com credenciais válidas")
    public void testLoginValido() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLogin();
        loginPage.login("uendel@test.com", "Password123");

        assertTrue(driver.getPageSource().contains("Logged in as"), "Login bem-sucedido!");
    }
}