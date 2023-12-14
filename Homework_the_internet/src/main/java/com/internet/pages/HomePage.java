package com.internet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "ul > li:nth-child(29) > a")
    WebElement javascriptAlerts;

    public JavaScriptAlertsPage getJavascriptAlerts() {
        click(javascriptAlerts);
        return new JavaScriptAlertsPage(driver);

    }

    @FindBy(css = " li:nth-child(33) > a")
    WebElement multipleWindows;

    public OpeningWindowPage getOpeningWindow() {
        click(multipleWindows);
        return new OpeningWindowPage(driver);
    }
}
