package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test(description = "Login with valid data")
    public void loginUsingCookie() {

        homePage.openHomePage();
        headerSection.setSessionCookie(cookie);
        Assert.assertEquals(headerSection.getUserInitial(), "N");

    }
}