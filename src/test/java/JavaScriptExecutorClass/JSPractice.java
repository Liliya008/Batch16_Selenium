package JavaScriptExecutorClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class JSPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.cssSelector("#yesRadio"));
//        Actions actions = new Actions(driver);
//        actions.click(yesButton).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",yesButton);
        Thread.sleep(1000);
        WebElement validateMessage = driver.findElement(By.xpath("//div//p"));
        Assert.assertEquals(BrowserUtils.getText(validateMessage), "You have selected Yes");
        Thread.sleep(1000);

        WebElement impressiveButton = driver.findElement(By.cssSelector("#impressiveRadio"));
        Actions actions = new Actions(driver);
        actions.click(impressiveButton).perform();
        validateMessage = driver.findElement(By.xpath("//div//p"));
        Assert.assertEquals(BrowserUtils.getText(validateMessage), "You have selected Impressive");

        WebElement noRadioButton = driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertFalse(noRadioButton.isEnabled());
    }
    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");

        WebElement copyrightMessage = driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
        BrowserUtils.scrollWithJS(driver,copyrightMessage);
        Assert.assertEquals(BrowserUtils.getText(copyrightMessage),"Copyright © 2023");
        Thread.sleep(2000);

        WebElement applyNowButton = driver.findElement(By.xpath("//span[.='APPLY NOW']"));
        Thread.sleep(2000);
        BrowserUtils.scrollWithJS(driver,applyNowButton);
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(driver,applyNowButton);

        Assert.assertEquals(BrowserUtils.getTitleWithJS(driver),"Apply Now");

        List<WebElement> allInfo = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> listExpected= Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");
        for (int i = 0; i < allInfo.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(allInfo.get(i)),listExpected.get(i));

            System.out.println(allInfo);
        }
    }}
