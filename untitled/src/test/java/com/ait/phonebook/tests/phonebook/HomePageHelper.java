package com.ait.phonebook.tests.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper{
    public HomePageHelper(WebDriver driver){
        super(driver);
    }
    protected boolean isHomeComponentPresent() {
        return driver.findElements(By.cssSelector("div:nth-child(2)>div>div>h1")).size() > 0;
    }
}
