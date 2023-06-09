package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenChartCustomersPage {
    public OpenChartCustomersPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@aria-label='Add New']")
    WebElement addNewCustomerButton;
    @FindBy(css = "#input-firstname")
    WebElement firstName;
    @FindBy(css ="#input-lastname")
    WebElement lastName;
    @FindBy(css ="#input-email")
    WebElement email;
    @FindBy(css = "#input-password")
    WebElement password;
    @FindBy(css = "#input-confirm")
    WebElement confirmPassword;
    @FindBy(css = "#input-newsletter")
    WebElement newsLetterCheckBox;
    @FindBy(css = "#input-status")
    WebElement statusCheckBox;
    @FindBy(css = "#input-safe")
    WebElement safeCheckBox;
    @FindBy(xpath = "//button[@aria-label='Save']")
    WebElement saveButton;
    @FindBy(xpath = "//div[contains(text(),' Warning')]")
    WebElement errorMessage;

    public void customersPageFunctionality(WebDriver driver,String firstName,String lastName,String email,String password,String confirmPassword) throws InterruptedException {
        addNewCustomerButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        BrowserUtils.scrollWithJS(driver, this.password);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);

        Thread.sleep(1000);

        if(newsLetterCheckBox.isDisplayed()&& newsLetterCheckBox.isEnabled()&& !newsLetterCheckBox.isSelected()){
           BrowserUtils.scrollWithJS(driver, newsLetterCheckBox);
            Thread.sleep(1000);
            newsLetterCheckBox.click();
        }
        if(statusCheckBox.isDisplayed() && statusCheckBox.isEnabled()&& !statusCheckBox.isSelected()){
            BrowserUtils.scrollWithJS(driver,statusCheckBox);
            Thread.sleep(1000);
            statusCheckBox.click();
        }
        if(safeCheckBox.isDisplayed()&&safeCheckBox.isEnabled()&&!safeCheckBox.isSelected()){
            BrowserUtils.scrollWithJS(driver,safeCheckBox);
            Thread.sleep(1000);
            safeCheckBox.click();
        }

        BrowserUtils.scrollWithJS(driver,saveButton);
        Thread.sleep(1000);
        saveButton.click();

    }
    public String errorMessage(){
        return BrowserUtils.getText(errorMessage);
    }
}
