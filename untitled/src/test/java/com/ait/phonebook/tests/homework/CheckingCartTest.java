package com.ait.phonebook.tests.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckingCartTest extends TestBaseWebShop{

    @BeforeMethod
    public void ensurePrecondition() {

        if (isElementComponentPresent(By.cssSelector("[href='/login']"))) {
            return;
        } else {

            By signOutSelector = By.cssSelector("[href='/login']");
            if (isElementComponentPresent(signOutSelector)) {
                click(signOutSelector);
            }
        }
        click(By.cssSelector("[href='/login']"));

        type(By.name("Email"), "utkina1@com.ua");

        type(By.name("Password"), "Utkina1234$");

        click(By.cssSelector(".button-1.login-button"));
    }


    @Test
    public void CheckingCartTest(){
        click(By.cssSelector("input.button-2.product-box-add-to-cart-button[value='Add to cart']"));
        type(By.cssSelector("input.recipient-name"), "Halina");
        type(By.cssSelector("input.recipient-email"), "utkina11.ga@gmail.com");
        click(By.cssSelector("input#add-to-cart-button-2"));

        click(By.cssSelector(".shopping-cart"));


    }
}
