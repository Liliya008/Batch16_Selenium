package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;


import java.time.Duration;

public class YouTubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.youtube.com/");

        //Thread.sleep(2000);
        //song.sendKeys(Keys.ARROW_DOWN)--> put this inside of loop

        WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("Ed Sheeran");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        List<WebElement> songs = driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement song:songs){
            Thread.sleep(500);
            song.sendKeys(Keys.ARROW_DOWN);
            if (song.getAttribute("aria-label").contains("Perfect")){
                song.click();
                break;
            }
        }





    }
}
