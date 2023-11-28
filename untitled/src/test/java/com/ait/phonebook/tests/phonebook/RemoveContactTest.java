package com.ait.phonebook.tests.phonebook;

import com.ait.phonebook.tests.phonebook.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSingOutButton();
        }
        app.getUser().clickLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("utkina16@gm.com")
                .setPassword("Utkina1234$"));
        app.getUser().clickOnLoginButton();
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("Petr")
                .setLastname("Kript")
                .setPhone("123654789123")
                .setEmail("peter@gm.com")
                .setAddress("Трубецкого")
                .setDeckription("jkklljjhgfd"));
        app.getContact().clickOnSaveButton();
    }
    @Test
    public  void removeContactPositiveTest(){
        int sizeBefore= app.getContact().sizeOfContacts();
        app.getContact().removeContact();
        app.getContact().pause(1000);
        int sizeAfter= app.getContact().sizeOfContacts();

        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

}
