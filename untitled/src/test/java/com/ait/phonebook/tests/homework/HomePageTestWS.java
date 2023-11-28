package com.ait.phonebook.tests.homework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTestWS extends TestBaseWebShop {


    @Test
    public void isHomeComponentPresentTest() {
      //  System.out.println("Home Component is"+"  "+isHomeComponentPresent());
        Assert.assertTrue(isHomeComponentPresent());

    }

}
