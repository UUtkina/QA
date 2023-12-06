package com.ait.phonebook.tests;


import model.User;

import model.Contact;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.ContactData;
import utils.DataProviders;
import utils.UserData;



public class AddNewContactTests extends TestBase{

//    @BeforeClass
//    public void beforeClass() {
//        System.out.println("*********************Before Class!");
//    }
//
//    @AfterClass
//    public void afterClass() {
//        System.out.println("********************After Class!");
//    }

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();

        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addNewContactPositivTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.NAME)
                .setLastname(ContactData.LAST_NAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription(ContactData.DESCRIPTION));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreatedByText("Petr"));


    }
    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }

}
