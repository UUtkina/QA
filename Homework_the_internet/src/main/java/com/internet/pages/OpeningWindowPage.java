package com.internet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpeningWindowPage extends BasePage {
    public OpeningWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#page-footer > div > div > a")
    WebElement linkElement;

    public void clickLinkElement() {
        click(linkElement);
          }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}

