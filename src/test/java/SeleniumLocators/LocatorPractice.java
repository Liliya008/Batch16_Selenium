package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorPractice {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
           /*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox). -->choose Both
7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Validate the url https://www.techlistic.com/p/selenium-practice-form.html
10-Close the webpage
Try your own logic and automate it without any help.
     */
        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("Liliya");

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("Kappanova");

        WebElement gender = driver.findElement(By.id("sex-1"));
        gender.click();

        WebElement experience = driver.findElement(By.id("exp-4"));
        experience.click();
        Thread.sleep(3000);

        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("05/16/2023");

        WebElement profession1 = driver.findElement(By.id("profession-0"));
        profession1.click();

        WebElement profession2 = driver.findElement(By.id("profession-1"));
        profession2.click();

        WebElement tool = driver.findElement(By.id("tool-2"));
        tool.click();

        WebElement continent = driver.findElement(By.className("input-xlarge"));
        continent.sendKeys("North America");

        WebElement button = driver.findElement(By.id("submit"));
        Thread.sleep(3000);
        button.click();

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl = "https://www.techlistic.com/p/selenium-practice-form.html";
        String url1 = actualUrl.equals(expectedUrl)?"Techlistic url passed":"Techlistic url failed";

        driver.quit();














    }
}
