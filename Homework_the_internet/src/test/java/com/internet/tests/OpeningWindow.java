package com.internet.tests;

import com.internet.pages.HomePage;
import com.internet.pages.OpeningWindowPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpeningWindow extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getOpeningWindow();
    }
    @Test
    public void linkElementalSeleniumTest() {
        OpeningWindowPage openingWindowPage = new OpeningWindowPage(driver);
        openingWindowPage.clickLinkElement();
        String currentUrl = openingWindowPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://elementalselenium.com/", "URL does not match expected.");
    }
}


