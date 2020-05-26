package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;


public class SignUpTest {

    @Test(description = "Sign Up with valid credential")
    public void signUpWithValidCredentials() {
        By signUpPopUpBtnLocator = By.xpath("(//button[@class='btn btn-primary'])[1]");
        By fullNameFieldLocator = By.id("id_fullname");
        By emailFieldLocator = By.id("email--1");
        By pwFieldLocator = By.id("password");
        By userInitialsLocator = By.xpath("//span[@class='user-initials']");
        By submitBtnLocator = By.xpath("//input[@id='submit-id-submit']");

        File chromeDriver = new File("src/main/resources/chromedriver.exe");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();

        WebDriver driver = new ChromeDriver(chromeService);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.get("https://www.udemy.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpPopUpBtnLocator));
        WebElement signUpPopUpBtn = driver.findElement(signUpPopUpBtnLocator);
        signUpPopUpBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameFieldLocator));
        WebElement fullNameField = driver.findElement(fullNameFieldLocator);
        fullNameField.clear();
        fullNameField.sendKeys("Nester Test");

        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.clear();
        emailField.sendKeys("test.nester@gmail.com");

        WebElement pwField = driver.findElement(pwFieldLocator);
        pwField.clear();
        pwField.sendKeys("147852Zx!");


        WebElement submitBtn = driver.findElement(By.xpath("//input[@id='submit-id-submit']"));
        submitBtn.click();


        WebElement submitBtn = driver.findElement(submitBtnLocator);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtnLocator));
        submitBtn.click();


        WebElement userInitials = driver.findElement(userInitialsLocator);
        pause(5000);
        Assert.assertEquals(userInitials.getText(),"NT");

        driver.quit();
    }
    private void pause(int milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
