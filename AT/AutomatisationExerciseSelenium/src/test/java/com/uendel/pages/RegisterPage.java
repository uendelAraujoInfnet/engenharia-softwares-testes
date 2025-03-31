package com.uendel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    private WebDriver driver;

    private By signupLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By nameField = By.name("name");
    private By emailField = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");
    private By titleMr = By.id("id_gender1");
    private By passwordField = By.id("password");
    private By daySelect = By.id("days");
    private By monthSelect = By.id("months");
    private By yearSelect = By.id("years");
    private By firstNameField = By.xpath("//input[@data-qa='first_name']");
    private By lastNameField = By.xpath("//input[@data-qa='last_name']");
    private By addressField = By.id("address1");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipCodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");
    private By createButton = By.xpath("//button[contains(text(),'Create Account')]");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void startRegistration(String name, String email) {
        driver.findElement(signupLink).click();
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(signupButton).click();
    }

    public void fillDetails(String password, String day, String month, String year, String firstName, String lastName, String address, String state, String city, String zipCode, String mobileNumber) {
        driver.findElement(titleMr).click();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(daySelect).sendKeys(day);
        driver.findElement(monthSelect).sendKeys(month);
        driver.findElement(yearSelect).sendKeys(year);
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipCodeField).sendKeys(zipCode);
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
    }

    public void submit() {

        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

        WebElement button = driver.findElement(createButton);

        // Scroll para o botão
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

        // Espera até que esteja clicável
        wait.until(ExpectedConditions.elementToBeClickable(button));

        button.click();
        //driver.findElement(createButton).click();
    }
}