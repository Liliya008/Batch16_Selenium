package com.test.blaze.pages;

import Utils.BrowserUtils;
import com.test.blaze.tests.BlazeTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class BlazeHomePage {

    public BlazeHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//a[@id='itemc']")
    List<WebElement> allItems;
    @FindBy(css = "#cartur")
    WebElement cartButton;

    public void homePageFunctionality(String itemName) throws InterruptedException {
        for (int i = 0; i < allItems.size(); i++) {
            if(BrowserUtils.getText(allItems.get(i)).equals(itemName)){
                allItems.get(i).click();
                break;
            }

        }
        Thread.sleep(3000);

    }
    public void clickCartButtonMethod(){
        cartButton.click();
    }
}
