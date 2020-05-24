package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;


public class SignUpTest {

    @Test(description = "Sign Up with valid credential")
    public void signUpWithValidCredentials() {

        File chromeDriver = new File("src/main/resources/chromedriver.exe");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();

        WebDriver driver = new ChromeDriver(chromeService);

        driver.get("https://www.udemy.com/");
        pause(4000);


        WebElement signUpPopUpBtn = driver.findElement(
                By.xpath("(//button[@class='btn btn-primary'])[1]"));
        signUpPopUpBtn.click();
        pause(5000);

        WebElement fullNameField = driver.findElement(By.id("id_fullname"));
        fullNameField.clear();
        fullNameField.sendKeys("Nester Test");

        WebElement emailField = driver.findElement(By.id("email--1"));
        emailField.clear();
        emailField.sendKeys("test.nester@gmail.com");

        WebElement pwField = driver.findElement(By.id("password"));
        pwField.clear();
        pwField.sendKeys("147852Zx!");

        WebElement submitBtn = driver.findElement(By.xpath("//input[@id='submit-id-submit']"));
        submitBtn.click();

        pause(4000);

        WebElement userInitials = driver.findElement(By.xpath("//span[@class='user-initials']"));
        Assert.assertEquals(userInitials.getText(),"NT");

        pause(5000);
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
