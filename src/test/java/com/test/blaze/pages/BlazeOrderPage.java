package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlazeOrderPage {
    public BlazeOrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#name")
    WebElement customerName;
    @FindBy(css = "#country")
    WebElement country;
    @FindBy(css = "#city")
    WebElement city;
    @FindBy(css = "#card")
    WebElement creditCardNumber;
    @FindBy(css = "#month")
    WebElement creditCardExpMonth;
    @FindBy(css = "#year")
    WebElement creditCardExpYear;
    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;
    @FindBy(xpath = "//h2[contains(text(),'Thank you')]")
    WebElement successfulOrderMessage;
    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public void fillingOrderPage(String customerName, String country, String city,String creditCardNumber, String creditCardExpMonth, String  creditCardExpYear,String expectedSuccessfulOrderMessage) throws InterruptedException {
       this.customerName.sendKeys(customerName);
       this.country.sendKeys(country);
       this.city.sendKeys(city);
       this.creditCardNumber.sendKeys(creditCardNumber);
       this.creditCardExpMonth.sendKeys(creditCardExpMonth);
       this.creditCardExpYear.sendKeys(creditCardExpYear);
       purchaseButton.click();
       Thread.sleep(2000);
       Assert.assertEquals(BrowserUtils.getText(successfulOrderMessage),expectedSuccessfulOrderMessage);
       Thread.sleep(2000);
       okButton.click();




    }
}
