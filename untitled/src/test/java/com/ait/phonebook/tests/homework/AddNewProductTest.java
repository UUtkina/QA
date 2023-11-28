package com.ait.phonebook.tests.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddNewProductTest extends TestBaseWebShop {

    @BeforeMethod
    public void ensurePrecondition() {

        if (isElementComponentPresent(By.cssSelector("[href='/login']"))) {

            return;
        } else {
            By signOutSelector = By.cssSelector("div.header-links > ul > li:nth-child(2) > a");
            if (isElementComponentPresent(signOutSelector)) {
                click(signOutSelector);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/login']")));
            }
        }
        click(By.cssSelector("[href='/login']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.name("Email")));
        emailField.clear();
        emailField.sendKeys("utkina1@com.ua");

        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.name("Password")));
        passwordField.clear();
        passwordField.sendKeys("Utkina1234$");

        click(By.cssSelector(".button-1.login-button"));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("element that signifies successful login")));
        System.out.println("Login process completed.");
    }

    @Test
    public void addNewProdukt() {
        click(By.cssSelector("input.button-2.product-box-add-to-cart-button[value='Add to cart']"));
        type(By.cssSelector("input.recipient-name"), "Halina");
        type(By.cssSelector("input.recipient-email"), "utkina11.ga@gmail.com");
        click(By.cssSelector("input#add-to-cart-button-2"));
        Assert.assertTrue(isElementComponentPresent(By.cssSelector("[href='/cart']")), "shopping cart button should be visible after registration");

    }
}
