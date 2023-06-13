package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class BlazeLaptopPage {
    public BlazeLaptopPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = (".hrefch"))
    List<WebElement> allLaptop;

    public void laptopPageFunctionality(String laptopName){
        for (int i = 0; i < allLaptop.size(); i++) {
            if (BrowserUtils.getText(allLaptop.get(i)).contains(laptopName)){
                allLaptop.get(i).click();
                break;
            }

        }
    }
}
