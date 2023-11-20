package com.ait.phonebook.tests;

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

            By signOutSelector = By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a");
            if (isElementComponentPresent(signOutSelector)) {
                driver.findElement(signOutSelector).click();
            }
        }
         }
    @Test
    public void createNewAccountPositiveTest() {
        driver.findElement(By.cssSelector("[href='/register']")).click();

        By firstNameLocator = By.name("FirstName");
        driver.findElement(firstNameLocator).clear();
        driver.findElement(firstNameLocator).sendKeys("Halina");

        By lastNameLocator = By.name("LastName");
        driver.findElement(lastNameLocator).clear();
        driver.findElement(lastNameLocator).sendKeys("Utkina");

        By emailLocator = By.name("Email");
        driver.findElement(emailLocator).clear();
        driver.findElement(emailLocator).sendKeys("utkina1@com.ua");

        By passwordLocator = By.name("Password");
        driver.findElement(passwordLocator).clear();
        driver.findElement(passwordLocator).sendKeys("11Ghjkl$i5");

        By confirmPasswordLocator = By.name("ConfirmPassword");
        driver.findElement(confirmPasswordLocator).clear();
        driver.findElement(confirmPasswordLocator).sendKeys("11Ghjkl$i5");

        driver.findElement(By.name("register-button")).click();

        // Temporary wait to check if it's a timing issue
        try {
            Thread.sleep(3000); // Wait 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Debug output
        System.out.println(driver.getPageSource()); // Or use logging

        // Assertion
        Assert.assertTrue(isElementComponentPresent(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a")), "Log Out button should be visible after registration");
    }
}
