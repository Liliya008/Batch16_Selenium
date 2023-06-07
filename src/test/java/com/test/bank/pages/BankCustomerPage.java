package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankCustomerPage {
    public BankCustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#userSelect")
    WebElement yourName;

    @FindBy(xpath = "//button[.='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//strong[contains(text(),' Welcome ')]")
    WebElement header;

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountForDeposit;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositSubmitButton;

    @FindBy(xpath = "//span[.='Deposit Successful']")
    WebElement successfulDepositMessage;

    @FindBy (xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawlButton;
    @FindBy(xpath = "//button[.='Withdraw']")
    WebElement withdrawSubmitButton;

    @FindBy(xpath = "//span[.='Transaction successful']")
    WebElement successfulTransaction;
    @FindBy(xpath = "//strong[.='200']")
    WebElement customerBalance;
    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionsButton;
    @FindBy (xpath = "//td[.='500']")
    WebElement credit;
    @FindBy(xpath = "//td[.='300']")
    WebElement debit;

    public void CustomerPageComponentsValidation(String yourName, String expectedHeader, String amount, String expectedDepositMessage,String expectedTransactionMessage) throws InterruptedException {
        BrowserUtils.selectBy(this.yourName,yourName,"text");
       loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        depositButton.click();
      amountForDeposit.sendKeys("500");
      Thread.sleep(2000);
      depositSubmitButton.click();
      Assert.assertEquals(BrowserUtils.getText(successfulDepositMessage),expectedDepositMessage);
      withdrawlButton.click();
        Thread.sleep(2000);
      amountForDeposit.sendKeys("300");
      Thread.sleep(2000);
      withdrawSubmitButton.click();
      Assert.assertEquals(BrowserUtils.getText(successfulTransaction),expectedTransactionMessage);
      Thread.sleep(2000);
      int customerbalance = Integer.parseInt(BrowserUtils.getText(customerBalance));
      transactionsButton.click();
      Thread.sleep(3000);
      Assert.assertEquals(((Integer.parseInt(BrowserUtils.getText(credit)))-(Integer.parseInt(BrowserUtils.getText(debit)))),customerbalance);




    }
}
