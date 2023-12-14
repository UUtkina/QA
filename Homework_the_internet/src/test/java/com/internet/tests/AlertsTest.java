package com.internet.tests;


import com.internet.pages.HomePage;
import com.internet.pages.JavaScriptAlertsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getJavascriptAlerts();
    }

    @Test
    public void clickJSAlertTest(){
        new JavaScriptAlertsPage(driver).clickForJSAlert();
    }

    @Test
    public void alertWithSelecrtTest(){
        new JavaScriptAlertsPage(driver).selektResult("Cancel").verifyResult("Cancel");
    }

@Test
    public void sendMessageToAlertTest(){
    new JavaScriptAlertsPage(driver).sendMessageToAlert("Adventszeit!").verifyMassage("Adventszeit!");
}
}
