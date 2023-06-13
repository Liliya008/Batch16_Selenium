package com.test.spruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpruceFishSeaFoodPage {

    public SpruceFishSeaFoodPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#search-form-input")
    WebElement findRecipe;

    public void findRecipeMethod(WebDriver driver, String findRecipe) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.click(this.findRecipe).perform();
        this.findRecipe.sendKeys(findRecipe);
        this.findRecipe.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

    }
}
