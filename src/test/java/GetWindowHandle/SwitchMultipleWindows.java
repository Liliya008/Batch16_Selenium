package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {
    @Test
    public void practiceMultipleWindows() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");

        String mainPage = driver.getWindowHandle();
        Set<String> allPages = driver.getWindowHandles();
        for(String id:allPages){
            if(!id.equals(mainPage)){
                driver.switchTo().window(id);
                break;
            }
        }
        BrowserUtils.switchByTitle(driver,"Contact us");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver, "Kickstart");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver, "Courses");
        System.out.println(driver.getTitle());
    }
    @Test
    public void RealTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
                     /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */
        WebElement button4 = driver.findElement(By.cssSelector("#newTabsBtn"));
        BrowserUtils.scrollWithJS(driver,button4);
        button4.click();
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver,"Basic Controls - H Y R Tutorials");
        WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Liliya");
        WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("Kappanova");
        WebElement gender = driver.findElement(By.cssSelector("#femalerb"));
        BrowserUtils.scrollWithJS(driver,gender);
        gender.click();
        WebElement languagesKnown = driver.findElement(By.cssSelector("#englishchbx"));
        languagesKnown.click();
        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("liliya@gmail.com");
        WebElement password= driver.findElement(By.cssSelector("#password"));
        password.sendKeys("abc123");
        WebElement registerButton = driver.findElement(By.cssSelector("#registerbtn"));
        Thread.sleep(1000);
        registerButton.click();
        WebElement successfullyRegistration = driver.findElement(By.xpath("//label[contains(text(),'Registration')]"));
        Assert.assertEquals(BrowserUtils.getText(successfullyRegistration),"Registration is Successful");
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver, "Window Handles Practice - H Y R Tutorials");
        WebElement header = driver.findElement(By.xpath("//h1[@ itemprop='name']"));
        Assert.assertEquals(BrowserUtils.getText(header),"Window Handles Practice");
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver,"AlertsDemo - H Y R Tutorials");
        WebElement promptBox= driver.findElement(By.cssSelector("#promptBox"));
        Thread.sleep(1000);
        promptBox.click();
        driver.quit();

    }
}
