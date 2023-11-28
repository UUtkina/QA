package com.ait.phonebook.tests.homework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewAccountTestWS extends TestBaseWebShop {

    @BeforeMethod
    public void ensurePrecondition() {

        if (isElementComponentPresent(By.cssSelector("[href='/register']"))) {
            return;
        } else {

            By signOutSelector = By.cssSelector("div.header-links > ul > li:nth-child(2) > a");
            if (isElementComponentPresent(signOutSelector)) {
                click(signOutSelector);
            }
        }
         }
    @Test
    public void createNewAccountNegativeTest() {
        click(By.cssSelector("[href='/register']"));

        type(By.name("FirstName"), "Halina11");

        type(By.name("LastName"), "Utkina111");

        type(By.name("Email"), "utkin11111@com.ua");


        type(By.name("Password"), "Utkina121134$");

        type(By.name("ConfirmPassword"), "Utkina121134$");

        click(By.name("register-button"));

        // Temporary wait to check if it's a timing issue
        try {
            Thread.sleep(3000); // Wait 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Debug output
        System.out.println(driver.getPageSource()); // Or use logging

        // Assertion
        Assert.assertTrue(isElementComponentPresent(By.cssSelector("[href='/logout']")), "Continue button should be visible after registration");

    }


}
