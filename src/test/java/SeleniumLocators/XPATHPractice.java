package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstname = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstname.sendKeys("Liliya");

        WebElement lastname = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastname.sendKeys("Kappanova");

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("fj7hgh2@gmail.com");

        WebElement phone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        phone.sendKeys("3312546798");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("liliya1234");

        WebElement passwordConfirm = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        passwordConfirm.sendKeys("liliya1234");

        WebElement subscribe = driver.findElement(By.xpath("//input[@name='newsletter']"));
        subscribe.click();

        WebElement privacyPolicy = driver.findElement(By.xpath("//input[@name='agree']"));
        privacyPolicy.click();
        Thread.sleep(3000);

        WebElement Continue= driver.findElement(By.xpath("//input[@value='Continue']"));
        Continue.click();


        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "Your Account Has Been Created!";
        String result = actualHeader.equals(expectedHeader) ? "Passed" : "Failed";
        System.out.println(result);

        WebElement Continue2 = driver.findElement(By.xpath("//a[contains(text(),'Continue')]"));
        Continue2.click();


        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/account";
        String url= currentUrl.equals(expectedUrl)?"Url Passed":"Url Failed";
        System.out.println(url);

    }
}
