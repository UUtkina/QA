package com.ait.phonebook.tests.phonebook;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSingOutButton();
        }
    }

    @Test
    public void addNewContactPositivTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("Petr")
                .setLastname("Kript")
                .setPhone("123654789123")
                .setEmail("peter@gm.com")
                .setAddress("Трубецкого")
                .setDeckription("jkklljjhgfd"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreatedByText("Petr"));


    }
    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }

}
