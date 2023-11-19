package com.ait.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewAccountTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (isElementComponentPresent(By.cssSelector("[href='/login']"))) {
            return; // If login link is present, no need to sign out.
        }
        if (isElementComponentPresent(By.xpath("//button[.='Sign Out']"))) {
            driver.findElement(By.xpath("//button[.='Sign Out']")).click();
        }
        // Add else block if needed to handle cases where neither element is present.
    }

    @Test
    public void createNewAccountPositiveTest() {
        driver.findElement(By.cssSelector("[href='/login']")).click();

        By emailLocator = By.name("email");
        driver.findElement(emailLocator).clear();
        driver.findElement(emailLocator).sendKeys("utkina1@com.ua");

        By passwordLocator = By.name("password");
        driver.findElement(passwordLocator).clear();
        driver.findElement(passwordLocator).sendKeys("11Ghjkl$i5");

        driver.findElement(By.name("registration")).click();

        // Temporary wait to check if it's a timing issue
        try {
            Thread.sleep(3000); // Wait 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Debug output
        System.out.println(driver.getPageSource()); // Or use logging

        // Assertion
        Assert.assertTrue(isElementComponentPresent(By.xpath("//button[.='Sign Out']")), "Sign Out button should be visible after registration");
    }
}
