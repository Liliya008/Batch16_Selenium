package FrameAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class FramePractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));


        driver.switchTo().frame("mce_0_ifr");
        WebElement box = driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        System.out.println(BrowserUtils.getText(header));
    }
    /*
    TASK 1:
      1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
      2-Click pavilion (new tab will be opened, consider switch window)
      3-Choose "Selenium-Phyton" from Selenium button (Action class is suggested)
      4-Validate the Header "Selenium-Python Tutorial"
      5-Print out(NO validation) all the links from website
      6-Wait for Second task
     */
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");

        WebElement pavilionButton=driver.findElement(By.xpath("//a[.='Pavilion']"));
        pavilionButton.click();
        BrowserUtils.switchByTitle(driver, "Home - qavalidation");
        WebElement selenium = driver.findElement(By.linkText("Selenium"));
        Actions action = new Actions(driver);
        action.moveToElement(selenium).perform();
        WebElement seleniumPhyton = driver.findElement(By.linkText("Selenium-Python"));
        seleniumPhyton.click();
        WebElement header = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(header), "Selenium-Python Tutorial");
        List<WebElement> allLink = driver.findElements(By.xpath("//p//a"));
        for (int i = 0; i < allLink.size(); i++) {
            System.out.println(BrowserUtils.getText(allLink.get(i)));
        }
              /*
TASK 2:
1-Go back to the main page "iframe"
2-click category 1
3-Validate the header "Category Archives: SeleniumTesting"
4-Print out all the headers of the contents(i will show you)
 */
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement category1 = driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver, "SeleniumTesting Archives - qavalidation");
        WebElement headerCategory1 = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(BrowserUtils.getText(headerCategory1),"Category Archives: SeleniumTesting");
        List<WebElement> allHeader = driver.findElements(By.xpath("//h3//a"));
        for (int i = 0; i < allHeader.size(); i++) {
            System.out.println(BrowserUtils.getText(allHeader.get(i)));

        }
 /*
TASK 3:
1-Go back mainPage
2-Click Category3
3-Validate the header "Category Archives: SoftwareTesting"

 */
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement message = driver.findElement(By.cssSelector("#frametext"));
        System.out.println(BrowserUtils.getText(message));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement category3 = driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");
        WebElement header2 = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(BrowserUtils.getText(header2),"Category Archives: SoftwareTesting");


    }
}
