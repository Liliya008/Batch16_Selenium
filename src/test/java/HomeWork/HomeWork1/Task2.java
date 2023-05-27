package HomeWork.HomeWork1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task2 {
    public static void main(String[] args) {
        /*
        Navigate to "https://www.saucedemo.com/" Enter username "Java"
Enter password "Selenium"
Click Login button
Validate "Epic sadface: Username and password do not match any user in this service" message
TIPS:to be able to see this message you need to first see this message then try to inspect it.
(it means at least run one time with the username and password you provided above to see the message
then inspect the message.*be careful with it is fully copied or not.
         */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        WebElement epicSadFace = driver.findElement(By.tagName("h3"));
        String epic= epicSadFace.getText();
        if (epic.equals("Epic sadface: Username and password do not match any user in this service")){
            System.out.println("Correct");
        }else{
            System.out.println("Incorrect");
        }
        driver.close();
    }
}
