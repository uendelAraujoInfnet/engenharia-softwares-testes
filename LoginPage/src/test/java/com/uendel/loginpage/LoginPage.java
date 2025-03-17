package com.uendel.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://practicetestautomation.com/practice-test-login/
public class LoginPage {
    @FindBy(name = "username")
    public WebElement inputUsername;

    @FindBy(name = "password")
    public WebElement inputPassword;

    @FindBy(xpath = "//*[text() = 'Submit']")
    public WebElement buttonSubmit;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}