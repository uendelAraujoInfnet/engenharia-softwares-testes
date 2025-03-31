package com.uendel.tests;

import com.uendel.core.BaseTest;
import com.uendel.pages.RegisterPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest extends BaseTest {

    @Test
    @DisplayName("Cadastro de novo usuário com sucesso")
    public void testCadastroUsuario() {
        RegisterPage registerPage = new RegisterPage(driver);
        String nome = "Uendel Teste";
        String email = "uendel_" + UUID.randomUUID().toString().substring(0, 8) + "@email.com";

        registerPage.startRegistration(nome, email);
        registerPage.fillDetails("senha123", "10", "May", "1995","Uendel","Araujo","Quebec","Quebec","Quebec City","G1X 4C3","55998877558");
        registerPage.submit();

        assertTrue(driver.getPageSource().contains("Account Created!"),
                   "Usuário deve ser cadastrado com sucesso.");
    }
}