package HomeWork.HomeWork1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Navigate to "https://www.saucedemo.com/" Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Validate current url is "https://www.saucedemo.com/inventory.html"
         */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement userName= driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        Thread.sleep(3000);
        WebElement loginButton= driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        String actualUrl= driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String result = actualUrl.equals(expectedUrl)?"url passed":"url failed";
        System.out.println(result);
        driver.close();


    }
}
