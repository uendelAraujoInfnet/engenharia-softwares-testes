package com.uendel.prestashop;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersistentLoginTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.prestashop.com/#/en/front");

        // Espera o iframe carregar e troca para ele
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                d -> d.findElement(By.cssSelector("iframe#framelive")).isDisplayed()
        );
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe#framelive")));
    }

    @Test
    @Order(1)
    void loginAndSaveCookies() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.login("teste@teste.com", "@teste12345678");

        Assertions.assertTrue(new HomePage(driver).isLoggedIn(), "Falha no login.");

        CookieUtils.saveCookies(driver);
    }

    @Test
    @Order(2)
    void loginUsingSavedCookies() {
        driver.manage().deleteAllCookies();
        CookieUtils.loadCookies(driver);
        driver.navigate().refresh(); // recarrega e mantemos no iframe

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                d -> d.findElements(By.cssSelector(".account span")).size() > 0
        );

        Assertions.assertTrue(new HomePage(driver).isLoggedIn(), "Usuário não está logado com cookies.");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
