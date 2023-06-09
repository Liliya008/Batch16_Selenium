package com.test.openchart.tests;

import com.test.openchart.pages.OpenChartCustomersPage;
import com.test.openchart.pages.OpenChartHomePage;
import com.test.openchart.pages.OpenChartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChartCustomerTest extends OpenChartTestBase{
    @Test
    public void homePageFunctionality() throws InterruptedException {
        OpenChartLoginPage openChartLoginPage=new OpenChartLoginPage(driver);
        openChartLoginPage.validateLoginPage("demo","demo");
        OpenChartHomePage openChartHomePage=new OpenChartHomePage(driver);
        openChartHomePage.homePageFunctionality();
        OpenChartCustomersPage openChartCustomersPage=new OpenChartCustomersPage(driver);
        openChartCustomersPage.customersPageFunctionality(driver, "Liliya","Kappanova","dfgh@gmail.com","12345","12345");
        Assert.assertEquals(openChartCustomersPage.errorMessage(),"Warning: You do not have permission to modify customers!");

    }
}
