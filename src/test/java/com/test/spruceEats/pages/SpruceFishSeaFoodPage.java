package com.test.spruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishSeaFoodPage {

    public FishSeaFoodPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#search-form-input")
    WebElement findRecipe;

    public void findRecipeMethod(WebDriver driver,String findRecipe) throws InterruptedException {
        BrowserUtils.scrollWithJS(driver, this.findRecipe);
        Thread.sleep(1000);
        this.findRecipe.sendKeys(findRecipe);
        this.findRecipe.sendKeys(Keys.ENTER);

    }
}
