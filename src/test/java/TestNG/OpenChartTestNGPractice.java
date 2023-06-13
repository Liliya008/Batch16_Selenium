package TestNG;

import Utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPractice {
    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(ConfigReader.readProperty("QA_url"));

        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys(ConfigReader.readProperty("QA_openChart_username"));

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys(ConfigReader.readProperty("QA_openChart_password"));

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(2000);

        String actual = driver.getTitle().trim();
        String expected = "Dashboard";
        Assert.assertEquals(actual, expected);
        Thread.sleep(3000);

    }

    @Test
    public void NegativeLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("Demo");

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement message = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        Thread.sleep(2000);
        Assert.assertEquals(message.getText().trim(), "No match for Username and/or Password.");
        Thread.sleep(3000);
    }

    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();

        WebElement closeButton = driver.findElement(By.cssSelector(".btn-close"));
        closeButton.click();

        WebElement catalog = driver.findElement(By.xpath("//a[@href='#collapse-1']"));
        catalog.click();
        Thread.sleep(2000);

        WebElement products = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        Assert.assertTrue(products.isDisplayed());
        Assert.assertTrue(products.isEnabled());
        Thread.sleep(3000);
    }

    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();

        WebElement closeButton = driver.findElement(By.cssSelector(".btn-close"));
        closeButton.click();

        WebElement catalog = driver.findElement(By.xpath("//a[@href='#collapse-1']"));
        catalog.click();
        Thread.sleep(2000);

        WebElement products = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        products.click();

        List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 1; i < boxes.size(); i++) {
            Thread.sleep(500);
            Assert.assertTrue(boxes.get(i).isDisplayed());
            Assert.assertTrue(boxes.get(i).isEnabled());
            Assert.assertFalse(boxes.get(i).isSelected());
            boxes.get(i).click();
            Assert.assertTrue(boxes.get(i).isSelected());
            boxes.get(i).sendKeys(Keys.ARROW_DOWN);

        }
        Thread.sleep(3000);
    }

    @Test
    public void validateProductNameFunctionalityAscendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();

        WebElement closeButton = driver.findElement(By.cssSelector(".btn-close"));
        closeButton.click();

        WebElement catalog = driver.findElement(By.xpath("//a[@href='#collapse-1']"));
        catalog.click();
        Thread.sleep(2000);

        WebElement products = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        products.click();

//        WebElement productNameButton = driver.findElement(By.cssSelector(".asc"));
//        productNameButton.click();
        Thread.sleep(1000);
        //ascending/dis ascending/comparison//sort--> reverse
        List<WebElement> allProducts = driver.findElements(By.xpath("//td[@class='text-start']"));//11 element
        List<String> actualProductOrder= new ArrayList<>();
        List<String> expectedProductOrder = new ArrayList<>();
        for (int i = 1; i <allProducts.size() ; i++) {
            actualProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());// same order same item
            expectedProductOrder.add(allProducts.get(i).getText().toLowerCase().trim()); // same order same item

        }
        Thread.sleep(1000);
        Collections.sort(expectedProductOrder);
        System.out.println(actualProductOrder);
        System.out.println(expectedProductOrder);
        //Collections.reverse(expectedProductOrder);
        Assert.assertEquals(actualProductOrder,expectedProductOrder);
        /*
        TEST CASE:
        1- You will click the productName button
        2- You should create 2 arrayList
         *-One of them will be actualData
         *- Another will be expectedData
        3- For(int i=1)
        *store all the names for both of the list. Please use at the end.toUpperCase or toLowerCase
        4- For expected List --> you will use Collections.sort(expectedList)
                            -->Collections.reverse(expected)
                            Assert.equals(actualList,expectedList)
         */
        Thread.sleep(3000);
    }
    @Test
    public void validateProductNameFunctionalityDisascendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();

        WebElement closeButton = driver.findElement(By.cssSelector(".btn-close"));
        closeButton.click();

        WebElement catalog = driver.findElement(By.xpath("//a[@href='#collapse-1']"));
        catalog.click();
        Thread.sleep(2000);

        WebElement products = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        products.click();

         WebElement productNameButton = driver.findElement(By.xpath("//a[.='Product Name']"));
        productNameButton.click();
        Thread.sleep(2000);
        //ascending/dis ascending/comparison
        List<WebElement> allProducts = driver.findElements(By.xpath("//td[@class='text-start']"));//11 element
        List<String> actualProductOrder= new ArrayList<>();
        List<String> expectedProductOrder = new ArrayList<>();
        Thread.sleep(3000);
        for (int i = 1; i <allProducts.size() ; i++) {
            actualProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());// same order same item
            expectedProductOrder.add(allProducts.get(i).getText().toLowerCase().trim()); // same order same item

        }
        Thread.sleep(1000);
        Collections.sort(expectedProductOrder);
        System.out.println(actualProductOrder);
        System.out.println(expectedProductOrder);
        Collections.reverse(expectedProductOrder);
        Assert.assertEquals(actualProductOrder,expectedProductOrder);
}}