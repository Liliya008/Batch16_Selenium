package com.test.spruceEats.pages;

import com.test.spruceEats.tests.SpruceEatsTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class SpruceEatsHomePage extends SpruceEatsTestBase {
    public SpruceEatsHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//span[.='Ingredients']")
    WebElement ingredients;
    @FindBy(xpath = "//a[.='Fish & Seafood']")
    WebElement fishSeafood;

    public void homePageFunctionality(WebDriver driver){
        Actions actions=new Actions(driver);
        actions.moveToElement(ingredients).perform();
        fishSeafood.click();
    }
}
