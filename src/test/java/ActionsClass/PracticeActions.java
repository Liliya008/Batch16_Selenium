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

public class PracticeActions {
    @Test
    public void practiceDragAndDrop() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement draggableBox = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppableBox = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        Assert.assertEquals(BrowserUtils.getText(droppableBox), "Drop here");

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggableBox, droppableBox).perform();

        Assert.assertEquals(droppableBox.getCssValue("background-color"),"rgba(70, 130, 180, 1)" );

        Assert.assertEquals(BrowserUtils.getText(droppableBox), "Dropped!");

    }

    @Test
    public void practiceClickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement accept = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        accept.click();

        WebElement notAcceptable = driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        Assert.assertEquals(BrowserUtils.getText(notAcceptable),"Not Acceptable");

        WebElement dropHere = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));
        Assert.assertEquals(BrowserUtils.getText(dropHere),"Drop here");

        Actions actions = new Actions(driver);
        actions.clickAndHold(notAcceptable).moveToElement(dropHere).release().perform();
        Assert.assertEquals(BrowserUtils.getText(dropHere),"Drop here");// after action


    }
}