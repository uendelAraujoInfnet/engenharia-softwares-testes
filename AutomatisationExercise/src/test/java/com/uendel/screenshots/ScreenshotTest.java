package com.uendel.screenshots;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScreenshotTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    void verifyContactPageAndCaptureScreenshots() {
        driver.get("https://automationexercise.com/");

        // Clica no botão "Contact us"
        WebElement contactUsBtn = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Contact us")));
        contactUsBtn.click();

        // Espera o título "GET IN TOUCH" da página aparecer
        WebElement title = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Get In Touch')]")));

        Assertions.assertTrue(title.isDisplayed(), "Título 'Get In Touch' não está visível!");

        // Screenshot da página inteira
        ScreenshotUtils.takeFullPageScreenshot(driver, "screenshots/contact_page_firefox.png");

        // Screenshot apenas do elemento
        ScreenshotUtils.takeElementScreenshot(title, "screenshots/contact_title_firefox.png");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}
