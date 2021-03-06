package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;

public class SignupForm {
    private WebDriver driver;
    private WebDriverWait wait;

    public SignupForm(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id ="id_fullname")
    public WebElement nameField;

    @FindBy(xpath="//input[@type='email']")
    public WebElement emailField;

    @FindBy(id ="password")
    public WebElement passwordField;

    @FindBy(xpath="//input[@value='Sign Up']")
    public WebElement signupButton;

    By signupPopupTitleLocator = By.xpath("//div[@class=' loginbox-v4__header loginbox-v4__header--signup']");
    By nameFieldLocator = By.xpath("//input[@id='id_fullname']");
    By emailAddressFieldLocator = By.xpath("//input[@id='email--1']");
    By passwordFieldLocator = By.xpath("//input[@id='password']");
    By submitSignupButtonLocator = By.xpath("//input[@id='submit-id-submit']");


    int timestamp = new Timestamp(System.currentTimeMillis()).getNanos();

    public String getSignupFormTitleText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupPopupTitleLocator));
        WebElement signupPopupTitle = driver.findElement(signupPopupTitleLocator);
        return signupPopupTitle.getText();
    }

    public SignupForm fillNameField(String name) {
        WebElement nameField = driver.findElement(nameFieldLocator);
        nameField.sendKeys(name);
        return this;
    }

    public SignupForm fillEmailAddressField(String email) {
        WebElement emailAddressField = driver.findElement(emailAddressFieldLocator);
        emailAddressField.sendKeys(email);
        return this;
    }

    public SignupForm fillPasswordField(String password) {
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys(password);
        return this;
    }

    public void submitForm() {
        wait.until(ExpectedConditions.elementToBeClickable(submitSignupButtonLocator));
        WebElement submitSignupButton = driver.findElement(submitSignupButtonLocator);
        submitSignupButton.click();
    }

}