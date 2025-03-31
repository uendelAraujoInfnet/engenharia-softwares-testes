package com.uendel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By loginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.xpath("//button[contains(text(),'Login')]");
    private By errorMessage = By.xpath("//p[contains(text(),'incorrect!')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLogin() {
        driver.findElement(loginLink).click();
    }

    public void login(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}