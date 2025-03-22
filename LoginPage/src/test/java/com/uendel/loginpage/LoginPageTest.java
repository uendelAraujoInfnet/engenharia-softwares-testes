package com.uendel.loginpage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class LoginPageTest {

    WebDriver webDriver;
    LoginPage loginPage;
    @BeforeEach
    void setUp() {
        webDriver = new ChromeDriver();
        webDriver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage = new LoginPage(webDriver);

    }

    @Test
    public void shouldLoginSuccessfully() {
        loginPage.inputUsername.sendKeys("student");
        loginPage.inputPassword.sendKeys("Password123");
        loginPage.buttonSubmit.click();
        WebElement logoutButton = webDriver.findElement(By.partialLinkText("Log out"));
        assertNotNull(logoutButton);
    }

    @Test
    public void shouldLoginSuccessfullyWithCorrectUsername(){
        loginPage.inputUsername.sendKeys("Arroz");
        loginPage.inputPassword.sendKeys("Password123");
        loginPage.buttonSubmit.click();
//        WebElement logoutButton = webDriver.findElement(By.partialLinkText("Log out"));
//        assertNotNull(logoutButton);
    }

    @Test
    public void shouldLoginSuccessfullyWithCorrectPassword(){
        loginPage.inputUsername.sendKeys("student");
        loginPage.inputPassword.sendKeys("ssword123");
        loginPage.buttonSubmit.click();
    }

    @AfterEach
    void tearDown() {
        //webDriver.quit();
    }
}