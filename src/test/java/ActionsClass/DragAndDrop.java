package ActionsClass;

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

import java.time.Duration;

public class DragAndDrop {
    @Test
    public void dragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        Assert.assertEquals(BrowserUtils.getText(orangeBox), "... Or here.");
        String actualBackGroundColor = orangeBox.getCssValue("background-color");
        String expecteedBackGroundColor="rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualBackGroundColor,expecteedBackGroundColor);

        WebElement blurCircle =driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
//        actions.scrollByAmount(200,200).perform(); --> scroll down --> no professional
        actions.dragAndDrop(blurCircle, orangeBox).perform();
        Thread.sleep(2000);
        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        Assert.assertEquals(BrowserUtils.getText(orangeBox),"You did great!");// after drop and drag

    }
    @Test
    public void DragAndDropPractice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        Assert.assertEquals(blueBox.getText(),"Drag the small circle here ...");
        String actualBackGroundColor = blueBox.getCssValue("background-color").trim();
        String expectedBackGroundColor = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualBackGroundColor,expectedBackGroundColor);

        WebElement draggable =driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();

        Thread.sleep(2000);
        blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        Assert.assertEquals(blueBox.getText(),"You did great!");



    }
}