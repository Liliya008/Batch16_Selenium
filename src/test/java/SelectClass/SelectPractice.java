package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/liliakappanova/Desktop/Techtorial.html");

        WebElement countryBox = driver.findElement(By.xpath("//select[@name='country']"));
        Select country = new Select(countryBox);// it means I will choose an option from THAT BOX

        String actualFirstOption= country.getFirstSelectedOption().getText().trim();
        String expectedDefaultCountry="UNITED STATES";
        Assert.assertEquals(actualFirstOption,expectedDefaultCountry);

        List<WebElement> allCountry = country.getOptions();
        int counter = 0;
        for (int i = 0; i < allCountry.size(); i++) {
            System.out.println(allCountry.get(i).getText().trim());
            counter++;
        }
        System.out.println(counter);
        Thread.sleep(2000);


        country.selectByVisibleText("KAZAKHSTAN");
        Thread.sleep(1000);
        country.selectByValue("207");
        Thread.sleep(2000);
        country.selectByIndex(1);
    }

}