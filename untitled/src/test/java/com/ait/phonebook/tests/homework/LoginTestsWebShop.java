package com.ait.phonebook.tests.homework;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestsWebShop extends TestBaseWebShop {
    @BeforeMethod
    public void ensurePrecondition() {

        if (isElementComponentPresent(By.cssSelector("[href='/register']"))) {
            return;
        } else {

            By signOutSelector = By.cssSelector(" div.header-links > ul > li:nth-child(2) > a");
            if (isElementComponentPresent(signOutSelector)) {
                click(signOutSelector);
            }
        }

    }

    @Test
    public void loginRegisteredUsertPositivTest() {
        click(By.cssSelector("[href='/login']"));

        type(By.name("Email"), "utkina1@com.ua");

        type(By.name("Password"), "Utkina1234$");

        click(By.cssSelector(".button-1.login-button"));
    }
}
