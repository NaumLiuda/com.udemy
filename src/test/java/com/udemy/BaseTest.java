package com.udemy;

import com.udemy.pages.HomePage;
import com.udemy.pages.SearchResultsPage;
import com.udemy.pages.SignupForm;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public Cookie cookie;

    HomePage homePage;
    SignupForm signupForm;
    SearchResultsPage searchResultsPage;

    @BeforeMethod(description = "Open browser")
    public void openBrowser() {

        File chromeDriver = new File("src/main/resources/chromedriver.exe");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();

        driver = new ChromeDriver(chromeService);


        wait = new WebDriverWait(driver, 5);

        homePage = new HomePage(driver, wait);
        signupForm = new SignupForm(driver, wait);
        searchResultsPage = new SearchResultsPage(driver, wait);
    }

    @AfterMethod(description = "Close browser")
    public void closeBrowser() {
        driver.quit();
    }
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}