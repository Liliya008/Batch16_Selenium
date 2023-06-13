package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlazeMacBookPage {
    public BlazeMacBookPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h2[@class='name']")
    WebElement macbookHeader;
    @FindBy(xpath = "//h3[@class='price-container']")
    WebElement macbookPrice;

    @FindBy(xpath = "//div[@id='myTabContent']")
    WebElement macbookDescriptionParagraph;
    @FindBy(xpath = "//a[.='Add to cart']")
    WebElement addCartButton;

    public void macbookDescriptionValidation(String macbookHeaderExpected,String macbookPriceExpected,String macbookDescriptionParagraphExpected){
        Assert.assertEquals(BrowserUtils.getText(macbookHeader),macbookHeaderExpected);
        Assert.assertEquals(BrowserUtils.getText(macbookPrice),macbookPriceExpected);
        Assert.assertEquals(BrowserUtils.getText(macbookDescriptionParagraph),macbookDescriptionParagraphExpected);
    }

    public void clickAddCartMethod(WebDriver driver, String expectedMessage) throws InterruptedException {
        addCartButton.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),expectedMessage);
        alert.accept();
    }
}
