package com.test.bank.pages;

import Utils.BrowserUtils;
import Utils.ConfigReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.awt.*;

public class BankManagerPage {
    public BankManagerPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomerButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitAddCustomerButton;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccountButton;

    @FindBy(css = "#userSelect")
    WebElement customerName;

    @FindBy(css = "#currency")
    WebElement currency;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement processButton;

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customersButton;

    @FindBy(tagName = "input")
    WebElement searchBox;

    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement> allInformation;



    public void addCustomerFunctionality(WebDriver driver) throws InterruptedException {
        addCustomerButton.click();
        Thread.sleep(3000);
        firstName.sendKeys(ConfigReader.readProperty("Customer_name"));
        lastName.sendKeys(ConfigReader.readProperty("Customer_lastName"));
        postCode.sendKeys(ConfigReader.readProperty("Customer_zipCode"));
        submitAddCustomerButton.submit();
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(ConfigReader.readProperty("CustomerAdded_successfulMessage")));
        alert.accept();

    }
 public void OpenAccountFunctionality(WebDriver driver, String name,String currency,String expectedMessage) throws InterruptedException {
        openAccountButton.click();
        Thread.sleep(3000);
     BrowserUtils.selectBy(customerName,name,"text");
     BrowserUtils.selectBy(this.currency,currency,"value");
     processButton.click();
     Alert alert = driver.switchTo().alert();
     Assert.assertTrue(alert.getText().trim().contains(expectedMessage));
     alert.accept();
 }
 public void customersFunctionality(String customerName, String lastName, String postCode){
        customersButton.click();
        searchBox.sendKeys(customerName);
        List<String> expectedNames= Arrays.asList(customerName,lastName,postCode);
     for (int i = 0; i < allInformation.size(); i++) {
         Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedNames.get(i));

     }
 }

}
