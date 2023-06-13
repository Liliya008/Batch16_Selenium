package com.test.spruceEats.tests;

import Utils.BrowserUtils;
import com.test.spruceEats.pages.SpruceEatsHomePage;
import com.test.spruceEats.pages.SpruceFishRecipePage;
import com.test.spruceEats.pages.SpruceFishSeaFoodPage;
import org.testng.annotations.Test;

public class SpruceFishRecipeTest extends SpruceEatsTestBase{
    @Test

    public void spruceFishRecipePageValidation() throws InterruptedException {
        SpruceEatsHomePage spruceEatsHomePage=new SpruceEatsHomePage(driver);
        spruceEatsHomePage.homePageFunctionality(driver);
        SpruceFishSeaFoodPage spruceFishSeaFoodPage=new SpruceFishSeaFoodPage(driver);
        spruceFishSeaFoodPage.findRecipeMethod(driver, "Fish for dinner");
        SpruceFishRecipePage spruceFishRecipePage=new SpruceFishRecipePage(driver);
        spruceFishRecipePage.spruceFishRecipePageFunctionality(driver, "6-Ingredient Roasted Salmon Fillets");


    }

}
