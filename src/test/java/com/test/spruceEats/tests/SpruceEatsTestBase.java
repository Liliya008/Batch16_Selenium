package com.test.spruceEats.tests;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class SpruceEatsTestBase {
    public WebDriver driver;
    @BeforeMethod
    public  void setup(){

        driver= DriverHelper.getDriver();
        driver.navigate().to("https://www.thespruceeats.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws IOException {
        if(!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver,"SpruceEatsPictures");
        }
       driver.quit();
    }
}

