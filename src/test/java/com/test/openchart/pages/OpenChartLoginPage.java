package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenChartLoginPage {
    public OpenChartLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#input-username")
    WebElement userName;
    @FindBy(css = "#input-password")
    WebElement password;
    @FindBy(xpath= "//button[.=' Login']")
    WebElement loginButton;
    @FindBy(css = "#alert")
    WebElement errorMessage;




    public void validateLoginPage(String userName, String password) throws InterruptedException {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
        Thread.sleep(2000);

    }
    public String errorMessage(){
        return BrowserUtils.getText(errorMessage);

    }
}
