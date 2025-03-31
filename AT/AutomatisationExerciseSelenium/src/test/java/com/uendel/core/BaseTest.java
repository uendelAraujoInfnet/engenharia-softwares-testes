package com.uendel.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }

    @AfterEach
    public void tearDown(org.junit.jupiter.api.TestInfo testInfo) {
        if (testInfo.getTags().contains("screenshotOnFail")) {
            com.uendel.utils.ScreenshotUtil.capture(driver, testInfo.getDisplayName());
        }
        if (driver != null) {
            driver.quit();
        }
    }
}