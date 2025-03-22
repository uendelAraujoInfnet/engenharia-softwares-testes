package com.uendel.automatisationexercise;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Define a ordenação pelos números de @Order
class AutomationExerciseTest {

   static WebDriver webDriver;
   static AutomationExercise automationExercise;

    @BeforeAll
    static void setUp() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.automationexercise.com/");
        automationExercise = new AutomationExercise(webDriver);
    }

    @Test
    @Order(1) // 1º - Clicar no botão de login
    public void shouldClickToGoToLogin(){
        automationExercise.loginButton.click();
    }

    @Test
    @Order(2) // 2º - Faz o passo inicial para registrar um novo usuário
    public void shouldRegisterNewUser() {
        automationExercise.inputSignupName.sendKeys("Abigobaldo");
        automationExercise.inputSignupEmail.sendKeys("Abigobaldo@gmail.com");
        automationExercise.buttonSignup.click();
    }

    @Test
    @Order(3) // 3º - Realiza o preenchimento dos campos de registro
    public void shouldCompleteRegisterFields() {
        automationExercise.inputPassword.sendKeys("Password123");
        automationExercise.inputFirstName.sendKeys("Abigobaldo");
        automationExercise.inputLastName.sendKeys("BaldoAbigo");
        automationExercise.inputAddress.sendKeys("Terra do Abigobaldo");
        automationExercise.inputState.sendKeys("Estado do Abigobaldo");
        automationExercise.inputCity.sendKeys("Terra do Abigobaldo");
        automationExercise.inputZipcode.sendKeys("12345");
        automationExercise.inputMobileNumber.sendKeys("1234567890");

        // Remover anúncios se existirem
        try {
            WebElement closeAd = webDriver.findElement(By.id("aswift_1_host"));
            if (closeAd.isDisplayed()) {
                JavascriptExecutor js = (JavascriptExecutor) webDriver;
                js.executeScript("arguments[0].remove();", closeAd);

            }
        } catch (NoSuchElementException e) {
            System.out.println("Nenhum anúncio encontrado.");
        }

        // Garante que o botão esteja visível e clicável
        automationExercise.buttonCreateAccount = webDriver.findElement(By.xpath("//button[@data-qa='create-account']"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", automationExercise.buttonCreateAccount);

        automationExercise.buttonCreateAccount.click();

        automationExercise.linkContinueButton.click();
    }

    @Test
    @Order(4) // 4º - Adicionar item ao carrinho
    public void shouldAddItemToCart() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        // Aguarda até que pelo menos um botão "Add to Cart" esteja visível
        wait.until(ExpectedConditions.visibilityOfAllElements(automationExercise.linkAddCart));

        // Seleciona o primeiro item da lista de botões e clica nele
        if (!automationExercise.linkAddCart.isEmpty()) {
            WebElement firstAddToCartButton = automationExercise.linkAddCart.get(0);

            // Rola até o botão para garantir que ele está visível
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", firstAddToCartButton);

            // Aguarda até que o botão esteja clicável e então clica
            wait.until(ExpectedConditions.elementToBeClickable(firstAddToCartButton)).click();

            System.out.println("Item adicionado ao carrinho com sucesso!");
        } else {
            fail("Nenhum botão 'Add to Cart' encontrado!");
        }
    }


    @AfterEach
    void tearDown() {
    }
}