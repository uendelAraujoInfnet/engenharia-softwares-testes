package com.uendel.prestashop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoggedIn() {
        return driver.findElements(By.cssSelector(".account span")).size() > 0;
    }
}
