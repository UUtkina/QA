package com.ait.phonebook.tests.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSingOutButton();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        app.getUser().clickLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("utkina16@gm.com")
                .setPassword("Utkina1234$"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSingOutButtonPresent());
    }
    @Test
    public void loginRegisteredUserNegaativeTest() {
        app.getUser().clickLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                 .setPassword("Utkina1234$"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}

