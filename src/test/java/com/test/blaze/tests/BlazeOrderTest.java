package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlazeOrderTest extends BlazeTestBase{
    @Test
    public  void orderPageFunctionality() throws InterruptedException {
        BlazeHomePage blazeHomePage=new BlazeHomePage(driver);
        blazeHomePage.homePageFunctionality("Laptops");
        BlazeLaptopPage blazeLaptopPage=new BlazeLaptopPage(driver);
        blazeLaptopPage.laptopPageFunctionality("MacBook Pro");
        BlazeMacBookPage blazeMacBookPage=new BlazeMacBookPage(driver);
        blazeMacBookPage.clickAddCartMethod(driver,"Product added");
        blazeHomePage.clickCartButtonMethod();
        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        blazeCartPage.cartPageValidation("MacBook Pro","1100");
        blazeCartPage.clickPlaceOrderMethod();
        BlazeOrderPage blazeOrderPage=new BlazeOrderPage(driver);
        blazeOrderPage.fillingOrderPage("Liliya","USA","Chicago","2345678978","08","2026","Thank you for your purchase!");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.demoblaze.com/index.html");
    }





}
