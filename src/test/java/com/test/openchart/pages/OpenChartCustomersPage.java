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

import java.util.ArrayList;
import java.util.List;

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
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement AllCheckBox;

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
        List<WebElement> allCheckBoxes= new ArrayList<>();
        for (int i = 0; i < allCheckBoxes.size(); i++) {
            if(allCheckBoxes.get(i).isDisplayed() && allCheckBoxes.get(i).isEnabled() && !allCheckBoxes.get(i).isSelected()){
                allCheckBoxes.get(i).click();
            }
        }

        BrowserUtils.scrollWithJS(driver,saveButton);
        Thread.sleep(1000);
        saveButton.click();

    }
    public String errorMessage(){
        return BrowserUtils.getText(errorMessage);
    }
}
