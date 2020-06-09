package com.udemy;


import org.testng.Assert;
import org.testng.annotations.Test;
import static com.udemy.testdata.UserData.basicUser;

public class SignUpTest extends BaseTest {

    @Test(description = "Registration with valid data")
    public void registrationWithValidData() {
        homePage.openHomePage();
        headerSection.openSignupPopup();
        Assert.assertEquals(signupForm.getSignupPopupTitleText(), "Sign Up and Start Learning!");
        signupForm.fillNameField(basicUser.getName())
                .fillEmailAddressField(basicUser.getEmail())
                .fillPasswordField(basicUser.getPassword())
                .submitForm();
        Assert.assertEquals(headerSection.getUserInitial(), basicUser.getName().substring(0,1));

    }
}
