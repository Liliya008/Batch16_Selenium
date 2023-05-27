package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElementPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();//setup
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();// maximize
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// wait times
        driver.navigate().to("https://the-internet.herokuapp.com/");//url

        List<WebElement> allLinks = driver.findElements(By.tagName("li"));//44
        int count = 0;
        int count2 =0;
        for (WebElement link: allLinks){
            System.out.println(link.getText().trim());
            count++;
            if (link.getText().length()>=12){
                count2++;

            }
        }
        System.out.println(count);//44
        System.out.println(count2);//31
    }
}
