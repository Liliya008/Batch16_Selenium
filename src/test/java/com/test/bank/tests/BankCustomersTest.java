package com.test.bank.tests;

import com.test.bank.pages.BankCustomerPage;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankCustomersTest {

    @Test
            public void validateCustomersPageComponents() throws InterruptedException {
         WebDriverManager.chromedriver().setup();
    ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    BankLoginPage loginPage=new BankLoginPage(driver);
    Thread.sleep(2000);
        loginPage.clickManagerButton();
    BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver,"Ahmet","Baldir","60123","Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver,"Ahmet Baldir","Dollar","Account created successfully with account Number");
        bankManagerPage.customersFunctionality("Ahmet","Baldir","60123");
        loginPage.clickHomeButton();
        loginPage.clickCustomerButton();
        BankCustomerPage bankCustomerPage= new BankCustomerPage(driver);
        bankCustomerPage.CustomerPageComponentsValidation("Ahmet Baldir", "Welcome Ahmet Baldir !!","500","Deposit Successful","Transaction successful");


}
}