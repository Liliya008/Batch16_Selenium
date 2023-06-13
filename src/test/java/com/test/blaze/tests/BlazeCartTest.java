package com.test.blaze.tests;

import com.test.blaze.pages.BlazeCartPage;
import com.test.blaze.pages.BlazeHomePage;
import com.test.blaze.pages.BlazeLaptopPage;
import com.test.blaze.pages.BlazeMacBookPage;
import org.testng.annotations.Test;

public class BlazeCartTest extends BlazeTestBase{
    @Test
    public void blazeCartPageValidation() throws InterruptedException {
        BlazeHomePage blazeHomePage=new BlazeHomePage(driver);
        blazeHomePage.homePageFunctionality("Laptops");
        BlazeLaptopPage blazeLaptopPage=new BlazeLaptopPage(driver);
        blazeLaptopPage.laptopPageFunctionality("MacBook Pro");
        BlazeMacBookPage blazeMacBookPage=new BlazeMacBookPage(driver);
        blazeMacBookPage.macbookDescriptionValidation("MacBook Pro","$1100 *includes tax","Product description\n" +
                "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
        blazeMacBookPage.clickAddCartMethod(driver,"Product added");
        blazeHomePage.clickCartButtonMethod();
        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        blazeCartPage.cartPageValidation("MacBook Pro","1100");
        blazeCartPage.clickPlaceOrderMethod();

    }
}
