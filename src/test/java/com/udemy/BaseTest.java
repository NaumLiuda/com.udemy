package com.udemy;

import com.udemy.pages.HeaderSection;
import com.udemy.pages.HomePage;
import com.udemy.pages.SearchResultsPage;
import com.udemy.pages.SignupForm;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.Date;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public Cookie cookie;

    HomePage homePage;
    HeaderSection headerSection;
    SignupForm signupForm;
    SearchResultsPage searchResultsPage;

    @BeforeClass(description = "Open browser")
    public void openBrowser() {

        File chromeDriver = new File("src/main/resources/chromedriver.exe");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();

        driver = new ChromeDriver(chromeService);

        cookie = new Cookie.Builder("dj_session_id", "z7cwyeabst2znldauu3kn7o676glogl2")
                .domain("www.udemy.com")
                .expiresOn(new Date(2020, 7, 8))
                .isHttpOnly(true)
                .isSecure(true)
                .path("/")
                .build();

        wait = new WebDriverWait(driver, 5);

        homePage = new HomePage(driver, wait);
        headerSection = new HeaderSection(driver, wait);
        signupForm = new SignupForm(driver, wait);
        searchResultsPage = new SearchResultsPage(driver, wait);
    }

    @AfterMethod(description = "Close browser")
    public void closeBrowser() {
        driver.quit();
    }
}