package com.udemy;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.udemy.testdata.UserData.basicUser;

public class LoginTest extends BaseTest {


    @Test(description = "Login with valid data")
    public void loginUsingCookie() {

        homePage.openHomePage();
        Cookie userLogin = new Cookie(basicUser.getCookieName(),basicUser.getCookieValue());
        driver.manage().addCookie(userLogin);
        driver.navigate().refresh();
        Assert.assertEquals(homePage.getUserLabel(),"N");
    }
}