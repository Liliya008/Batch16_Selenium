package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("file:///Users/liliakappanova/Desktop/Techtorial.html");

        //LINKTEXT LOCATOR

        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();

        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        String actualHeader = javaHeader.getText().trim();
        String expectedHeader = "Java";
        System.out.println(actualHeader.equals(expectedHeader) ? "CORRECT" : "FALSE");

        /*
      1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
      2-Go back to the main page
      3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
      4-Go back to the main page
      5-Click TestNG and validate(ternary) header -->TestNG
      6-Go back to the main page
      7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
 */

        driver.navigate().back();
        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement seleniumHeader = driver.findElement(By.tagName("h1"));
        System.out.println(seleniumHeader.getText());
        driver.navigate().back();
        Thread.sleep(3000);

        WebElement cucumberLink = driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        WebElement cucumberClass=driver.findElement(By.tagName("h1"));
        System.out.println(cucumberClass.getText());
        Thread.sleep(3000);

        driver.navigate().back();
        WebElement testNGLink = driver.findElement(By.linkText("TestNG"));
        testNGLink.click();
        WebElement testNGLinkHeader=driver.findElement(By.tagName("h2"));
        System.out.println(testNGLinkHeader.getText().equals("TestNG")? testNGLinkHeader.getText(): false);
        driver.navigate().back();
        javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();


        driver.navigate().back();
        driver.get("file:///Users/liliakappanova/Desktop/Techtorial.html");
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl = "file:///Users/liliakappanova/Desktop/Techtorial.html";
        System.out.println(actualUrl.equals(expectedUrl)? "CORRECT": "NOT CORRECT");

        //LOCATOR PARTIALLINKTEXT

        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());














    }
}
