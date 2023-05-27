package HomeWork.HomeWork1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TASK4 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();//setup
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();// maximize
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// wait times
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");//url

        WebElement address = driver.findElement(By.xpath("//p[contains(text(),'Atlanta 550 Pharr Road NE Suite 525')]"));
        System.out.println(address.getText());
    }
}
