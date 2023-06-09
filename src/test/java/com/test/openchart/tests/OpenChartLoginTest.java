package com.test.openchart.tests;

import Utils.BrowserUtils;
import com.test.openchart.pages.OpenChartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChartLoginTest extends OpenChartTestBase {
    @Test
    public void happyPathLogin() throws InterruptedException {
    OpenChartLoginPage openChartLoginPage=new OpenChartLoginPage(driver);
    openChartLoginPage.validateLoginPage("demo","demo");
    Assert.assertEquals(driver.getTitle().trim(),"Dashboard");

}
public void validateNegativeLogin() throws InterruptedException {
    OpenChartLoginPage openChartLoginPage=new OpenChartLoginPage(driver);
    openChartLoginPage.validateLoginPage("demo","234567");
    Assert.assertEquals(openChartLoginPage.errorMessage(),"No match for Username and/or Password.");

}
}