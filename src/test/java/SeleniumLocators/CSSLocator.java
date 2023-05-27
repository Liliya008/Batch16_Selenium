package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CSSLocator {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");

        WebElement searchBar = driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        searchBar.sendKeys("watch");

        WebElement searchButton = driver.findElement(By.cssSelector(".global-enhancements-search-input-btn-group__btn"));
        searchButton.click();

        String actualUrl= driver.getCurrentUrl();
        String expectedUrl = "https://www.etsy.com/search?q=watch&ref=search_bar";
        String url1 = actualUrl.equals(expectedUrl)?"url passed":"url failed";
        System.out.println(url1);
        driver.close();
    }
}
