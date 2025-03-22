package com.uendel.scroll;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class ScrollTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void verifyScrollUpAndDown() {
        driver.get("https://automationexercise.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Rola até o final da página
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Espera o botão #scrollUp ficar visível
        WebElement scrollUpButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("scrollUp")));

        Assertions.assertTrue(scrollUpButton.isDisplayed(), "Botão de scroll up não visível após rolar");

        // Clica no botão para subir
        scrollUpButton.click();

        // Aguarda o topo voltar e o logo da home estar visível
        WebElement logo = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".logo.pull-left")));

        Assertions.assertTrue(logo.isDisplayed(), "Não retornou ao topo da página");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}
