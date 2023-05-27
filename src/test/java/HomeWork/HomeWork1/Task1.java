package HomeWork.HomeWork1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Navigate to "https://demoqa.com/text-box"
Enter your full name, email, current and permanent address Click submit button.
Validate that all of your information is displayed and matching correctly.
TIPS:Think about if conditions. Example:
Name:John
Email: john@gmail.com
Current Address :Random Address Permanent Address : different address
         */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Liliya Kappanova");
        String fullname1 = fullName.getText();

        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("liliya87@gmail.com");
        String eMail = email.getText();

        WebElement currentAddress = driver.findElement(By.xpath("//textArea[@id='currentAddress']"));
        currentAddress.sendKeys("1294 Rand Road");
        String currentAddress1 = currentAddress.getText();

        WebElement permanentAddress = driver.findElement(By.xpath("//textArea[@id='permanentAddress']"));
        permanentAddress.sendKeys("1017 Plum Grove Rd");
        String permanentAddress1 = permanentAddress.getText();
        Thread.sleep(3000);

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submitButton.click();


        WebElement fullName2 = driver.findElement(By.xpath("//p[@id='name']"));
        String fullname2 = fullName2.getText();
        if (fullname2.contains(fullname1) && fullName2.isDisplayed()) {
            System.out.println("FullName Correct");
        }else{
            System.out.println("FullName Incorrect");
        }
        WebElement email2 = driver.findElement(By.xpath("//p[@id='email']"));
        String eMail2 = email2.getText();
        if(eMail2.contains(eMail) && email2.isDisplayed()){
            System.out.println("Email Correct");
        }else{
            System.out.println("Email Incorrect");
        }
        WebElement currentAddress2 = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String currenTAddress2 = currentAddress2.getText();
        if(currenTAddress2.contains(currentAddress1) && currentAddress2.isDisplayed()){
            System.out.println("Current Address Correct");
    }else{
        System.out.println("Current Address Incorrect");
    }
        WebElement permanentAddress2 = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String permanenTAddress2 = permanentAddress2.getText();
        if(permanenTAddress2.contains(permanentAddress1) && permanentAddress2.isDisplayed()){
            System.out.println("Permanent Address Correct");
        }else{
            System.out.println("Permanent Address Incorrect");
        }
        driver.close();
    }
}
