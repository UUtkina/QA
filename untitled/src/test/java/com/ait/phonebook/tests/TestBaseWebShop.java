package com.ait.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBaseWebShop {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");

        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue(isHomeComponentPresent());
    }


    protected boolean isHomeComponentPresent() {
        return driver.findElements(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header")).size() > 0;
    }

    boolean isElementComponentPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
