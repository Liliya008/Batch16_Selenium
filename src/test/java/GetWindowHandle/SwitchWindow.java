package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchPractice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");

        WebElement multiplyWindow = driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]"));
        multiplyWindow.click();

        WebElement clickHere = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
        clickHere.click();

        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));// Opening a new window
        System.out.println(driver.getWindowHandle()); // main page ID --> The Internet
        // 65EEC4147CAD53A6A2F60077EB03DDD6 --> main page
        //DAA1605787BD28189193196CAA35CFEA --> new page
        String mainPageID = driver.getWindowHandle();
        Set<String> allPagesID=driver.getWindowHandles();
        for(String id: allPagesID){
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        System.out.println(driver.getWindowHandle());
        header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
    }
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button2 = driver.findElement(By.cssSelector("#newTabBtn"));
        button2.click();

        String currentPageID = driver.getWindowHandle();
        Set<String> allPagesID = driver.getWindowHandles();
        for(String page:allPagesID){
            if(!page.equals(currentPageID)){
                driver.switchTo().window(page);
                break;
            }
        }
        WebElement header = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        Assert.assertEquals(BrowserUtils.getText(header),"AlertsDemo");
        Assert.assertEquals(driver.getTitle().trim(), "AlertsDemo - H Y R Tutorials");
        WebElement alertBox = driver.findElement(By.cssSelector("#alertBox"));
        alertBox.click();

    }
}