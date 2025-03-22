package com.uendel.automatisationexercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://www.automationexercise.com/
public class AutomationExercise {
    @FindBy(xpath = "//a[@href='/login']")
    public WebElement loginButton;

    @FindBy(css = "[data-qa = 'signup-name']")
    public WebElement inputSignupName;

    @FindBy(css = "[data-qa = 'signup-email']")
    public WebElement inputSignupEmail;

    @FindBy(css = "[data-qa = 'signup-button']")
    public WebElement buttonSignup;

    @FindBy(css = "[data-qa = 'password']")
    public WebElement inputPassword;

    @FindBy(css = "[data-qa = 'first_name']")
    public WebElement inputFirstName;

    @FindBy(css = "[data-qa = 'last_name']")
    public WebElement inputLastName;

    @FindBy(css = "[data-qa = 'address']")
    public WebElement inputAddress;

    @FindBy(css = "[data-qa = 'state']")
    public WebElement inputState;

    @FindBy(css = "[data-qa = 'city']")
    public WebElement inputCity;

    @FindBy(css = "[data-qa = 'zipcode']")
    public WebElement inputZipcode;

    @FindBy(css = "[data-qa = 'mobile_number']")
    public WebElement inputMobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement buttonCreateAccount;

    @FindBy(css = "[data-qa = 'continue-button']")
    public WebElement linkContinueButton;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a")
    public List<WebElement> linkAddCart;



    
    
    public AutomationExercise(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}