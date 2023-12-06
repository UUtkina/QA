package com.ait.phonebook.tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserData;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        app.getUser().clickOnLoginLink();
        logger.info("Test runs wit data " + UserData.EMAIL + " " + UserData.PASSWORD);
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));

        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }

    @Test
    public void loginRegisteredUserNegativeTestWithoutEmail() {
        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(new User()
                .setPassword(UserData.PASSWORD));

        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }


}