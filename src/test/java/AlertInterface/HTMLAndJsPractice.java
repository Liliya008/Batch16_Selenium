package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HTMLAndJsPractice {
    @Test
    public void practiceBoth() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://sweetalert.js.org/");

        WebElement preview1 = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        preview1.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),"Oops, something went wrong!");
        alert.accept();
        WebElement preview2= driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        preview2.click();
       WebElement message = driver.findElement(By.xpath("//div[@role='dialog']"));
       Thread.sleep(2000);
        System.out.println(BrowserUtils.getText(message));
        WebElement okButton = driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();
        // (//h5[contains(text(),'Normal alert')]//..//button) --> parent-child-parent-child !!!!
        Assert.assertTrue(BrowserUtils.getText(message).contains("Something went wrong!"));

        


    }
}