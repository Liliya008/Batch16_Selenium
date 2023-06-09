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

    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement successfulMessage;

    @FindBy (xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawlButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountforDrawal;
    @FindBy(xpath = "//button[.='Withdraw']")
    WebElement withdrawSubmitButton;


    @FindBy(xpath = "//div[@ng-hide='noAccount']//strong[2]")
    WebElement customerBalance;
    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionsButton;
    @FindBy (xpath = "//tr[@id='anchor0']//td[2]")
    WebElement credit;
    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement debit;

    public void loginFunctionality(String yourName, String expectedHeader){
        BrowserUtils.selectBy(this.yourName,yourName,"text");
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);

    }
    public void depositFunctionality(String depositAmount,String expectedDepositMessage){
        depositButton.click();
        amountForDeposit.sendKeys(depositAmount);
        depositSubmitButton.click();
        Assert.assertEquals(BrowserUtils.getText(successfulMessage),expectedDepositMessage);
    }

    public  void withDrawFunctionality(String withDrawlAmount, String expectedSuccessfulMessage) throws InterruptedException {
        withdrawlButton.click();
        Thread.sleep(500);
        amountforDrawal.sendKeys(withDrawlAmount);
        Thread.sleep(500);
        withdrawSubmitButton.click();
        Assert.assertEquals(BrowserUtils.getText(successfulMessage),expectedSuccessfulMessage);

    }
    public void transactionFunctionality() throws InterruptedException {
        int actualCustomerBalance= Integer.parseInt(BrowserUtils.getText(customerBalance));//200
        Thread.sleep(2000);
        transactionsButton.click();
        int expectedBalance=(Integer.parseInt(BrowserUtils.getText(credit))-Integer.parseInt(BrowserUtils.getText(debit)));
        Assert.assertEquals(actualCustomerBalance,expectedBalance);
    }





    }

