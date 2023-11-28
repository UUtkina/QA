package com.ait.phonebook.tests.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewAccountTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSingOutButton();
        }
    }

    @Test
    public void registerExistedUserNegativeTest() {
        //click on Login link
        app.getUser().clickLoginLink();
        //enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("utkina16@gm.com")
                .setPassword("Utkina1234$"));
        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        //assert Sign Out button is present
        //Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
