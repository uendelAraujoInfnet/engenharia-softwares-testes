package com.uendel.prestashop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginPage() {
        driver.findElement(By.cssSelector(".user-info")).click();
    }

    public void login(String email, String password) {
        driver.findElement(By.cssSelector("#field-email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("submit-login")).click();
    }
}