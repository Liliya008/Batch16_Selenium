package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BlazeCartPage {

    public BlazeCartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//td")
    List<WebElement> productsInfo;
    @FindBy(xpath = "//button[@class='btn btn-success']")
    WebElement placeOrderButton;

    public void cartPageValidation(String productNameExpected, String productPriceExpected) throws InterruptedException {
        List<String> expectedProductInfo = Arrays.asList("",productNameExpected,productPriceExpected,"");
        for (int i = 1; i < productsInfo.size()-1; i++) {
            Assert.assertEquals(BrowserUtils.getText(productsInfo.get(i)),expectedProductInfo.get(i));

        }
        Thread.sleep(2000);
    }
    public void clickPlaceOrderMethod(){
        placeOrderButton.click();
    }
}
