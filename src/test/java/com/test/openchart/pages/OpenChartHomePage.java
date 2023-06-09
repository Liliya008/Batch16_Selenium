package com.test.openchart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenChartHomePage {
    public  OpenChartHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".btn-close")
    WebElement closeButton;
    @FindBy(xpath = "//a[contains(text(),' Customers')]")
    WebElement cutomersButton;
    @FindBy(xpath = "//a[.='Customers']")
    WebElement cutomersPageButton;

    public void homePageFunctionality(){
        closeButton.click();
        cutomersButton.click();
        cutomersPageButton.click();
    }
}
