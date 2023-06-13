package com.test.spruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SpruceFishRecipePage {

    public SpruceFishRecipePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[contains(text(),'4Star')]//..//input")
    WebElement rating4Star;

    @FindBy(xpath = "//a//span[contains(text(),'Choice')]//..//input")
    WebElement popularEditorChoice;


    @FindBy(xpath = "//span[contains(text(),'6-Ingredient')]")
    WebElement recipeName;

    public void spruceFishRecipePageFunctionality(WebDriver driver, String expectedRecipeName) throws InterruptedException {
        Actions actions=new Actions(driver);
        actions.click(rating4Star).perform();
        if(popularEditorChoice.isEnabled() && !popularEditorChoice.isSelected()){
            Thread.sleep(2000);
            actions.click(popularEditorChoice).perform();
            Assert.assertEquals(BrowserUtils.getText(recipeName),expectedRecipeName);
        }

    }

}
