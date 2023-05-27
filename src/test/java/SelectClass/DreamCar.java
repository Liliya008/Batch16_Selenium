package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    @Test
    public void HeadersOfTheCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");
           /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */
        WebElement stockType = driver.findElement(By.xpath("//select[@name='stock_type']"));
        BrowserUtils.selectBy(stockType, "New", "text");

        WebElement makes = driver.findElement(By.xpath("//select[@name='makes[]']"));
        BrowserUtils.selectBy(makes, "lexus", "value");

        WebElement models = driver.findElement(By.xpath("//select[@name='models[]']"));
        BrowserUtils.selectBy(models, "  RX 350", "text");

        WebElement price = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select choicePrice = new Select(price);
        Assert.assertEquals(choicePrice.getFirstSelectedOption().getText().trim(), "No max price");

        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance, "40", "value");

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60056");

        WebElement searchButton = driver.findElement(By.xpath("//button[@data-searchtype='make']"));
        searchButton.click();

        WebElement header = driver.findElement(By.cssSelector(".sds-heading--1"));
        Assert.assertEquals(BrowserUtils.getText(header), "New Lexus RX 350 for sale");

        WebElement sortBy = driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        Thread.sleep(3000);
        BrowserUtils.selectBy(sortBy, "Lowest price", "text");
        Thread.sleep(3000);

        List<WebElement> titles = driver.findElements(By.xpath("//a[@data-linkname='vehicle-listing']"));
        Thread.sleep(2000);
        for (WebElement title : titles) {
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));
            System.out.println(BrowserUtils.getText(title));
        }
    }

    @Test
    public void priceOrderAscending() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");

        WebElement stockType = driver.findElement(By.xpath("//select[@name='stock_type']"));
        BrowserUtils.selectBy(stockType, "New", "text");

        WebElement makes = driver.findElement(By.xpath("//select[@name='makes[]']"));
        BrowserUtils.selectBy(makes, "lexus", "value");

        WebElement models = driver.findElement(By.xpath("//select[@name='models[]']"));
        BrowserUtils.selectBy(models, "  RX 350", "text");

        WebElement price = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select choicePrice = new Select(price);
        Assert.assertEquals(choicePrice.getFirstSelectedOption().getText().trim(), "No max price");

        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance, "40", "value");

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60056");

        WebElement searchButton = driver.findElement(By.xpath("//button[@data-searchtype='make']"));
        searchButton.click();

        WebElement header = driver.findElement(By.cssSelector(".sds-heading--1"));
        Assert.assertEquals(BrowserUtils.getText(header), "New Lexus RX 350 for sale");

        WebElement sortBy = driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        Thread.sleep(3000);
        BrowserUtils.selectBy(sortBy, "Lowest price", "text");
        Thread.sleep(3000);

        List<WebElement> priceValidate = driver.findElements(By.cssSelector(".primary-price"));
        List<Integer> actualPriceOrder = new ArrayList<>();
        List<Integer> expectedPriceOrder = new ArrayList<>();
        for (int i = 0; i < priceValidate.size(); i++) {
            actualPriceOrder.add(Integer.parseInt(BrowserUtils.getText(priceValidate.get(i)).trim().replace("$", "").replace(",", "")));
            expectedPriceOrder.add(Integer.parseInt(BrowserUtils.getText(priceValidate.get(i)).trim().replace("$", "").replace(",", "")));
            Collections.sort(expectedPriceOrder);
            System.out.println(actualPriceOrder);
            System.out.println(expectedPriceOrder);
            Assert.assertEquals(actualPriceOrder, expectedPriceOrder);

        }
    }
}
