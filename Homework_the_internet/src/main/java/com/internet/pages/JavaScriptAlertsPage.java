package com.internet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class JavaScriptAlertsPage extends BasePage {

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "li:nth-child(1) > button")
    WebElement clickJSAlert;

    public JavaScriptAlertsPage clickForJSAlert(){
        click(clickJSAlert);
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.alertIsPresent()).accept();
        return this;
    }
    @FindBy(css = "li:nth-child(2) > button")
    WebElement clickJSConfirm;
    public JavaScriptAlertsPage selektResult(String confirm) {
        click(clickJSConfirm);
        if (confirm!=null&&confirm.equals("OK")){
            driver.switchTo().alert().accept();
        }else if(confirm!=null&&confirm.equals("Cancel")){
            driver.switchTo().alert().dismiss();
        }
        return this;

    }
    @FindBy(id = "result")
    WebElement confirmResult;
    public JavaScriptAlertsPage verifyResult(String result) {
        Assert.assertTrue(confirmResult.getText().contains(result));
        return this;
    }
    @FindBy(css = "li:nth-child(3) > button")
    WebElement promtButton;
    public JavaScriptAlertsPage sendMessageToAlert(String massage) {
        driver.switchTo().alert().sendKeys(massage);
        driver.switchTo().alert().accept();
        return this;
          }
    @FindBy(id = "result")
    WebElement promptResult;
    public JavaScriptAlertsPage verifyMassage(String text) {
        Assert.assertTrue(promptResult.getText().contains(text));
        return  this;
    }
}


