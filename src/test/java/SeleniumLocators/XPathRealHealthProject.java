package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPathRealHealthProject {
    public static void main(String[] args) throws InterruptedException {
                /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.

           */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
// XPATH
//        WebElement appointment = driver.findElement(By.xpath("//a[contains(text(),'Make Appointment')]"));
//        appointment.click();
        //CSS
        WebElement appointment = driver.findElement(By.cssSelector("#btn-make-appointment"));
        appointment.click();

        WebElement username = driver.findElement(By.xpath("//input[@id='txt-username']"));
        username.sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();

        WebElement facility = driver.findElement(By.xpath("//select[@class='form-control']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");
        Thread.sleep(3000);

        WebElement apply = driver.findElement(By.xpath("//input[@name='hospital_readmission']"));
        if (apply.isDisplayed() && !apply.isSelected()){
        apply.click();
        }
        Thread.sleep(3000);
        WebElement healthCareProgram = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        healthCareProgram.click();

        WebElement date = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("05/17/2023");

        WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("I would like to change my doctor");

//        WebElement button = driver.findElement(By.xpath(" //button[.='Book Appointment']"));
//        button.click();
        //CSS WITH CLASS
        WebElement button = driver.findElement(By.xpath(".btn-default"));
        button.click();



        WebElement header = driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
        if (header.equals("Appointment Confirmation")){
            System.out.println("Validate");
           header.getText();
        }

        WebElement facility2 = driver.findElement(By.xpath("//p[.='Hongkong CURA Healthcare Center']"));
        System.out.println( facility2.getText());

        WebElement apply2 = driver.findElement(By.xpath("//p[.='Yes']"));
        System.out.println( apply2.getText());

        WebElement healthCareProgram2 = driver.findElement(By.xpath("//p[contains(text(),'Medicaid')]"));
        System.out.println(healthCareProgram2.getText());

        WebElement date2 = driver.findElement(By.xpath("//p[contains(text(),'05/05/2023')]"));
        System.out.println(date2.getText());

        WebElement comment2 = driver.findElement(By.xpath("//p[contains(text(),'I would like to change my doctor')]"));
        System.out.println(comment2.getText());

        WebElement homePage = driver.findElement(By.xpath(" //a[.='Go to Homepage']"));
        homePage.click();
        Thread.sleep(3000);

        String actualUrl= driver.getCurrentUrl();
        String expectedUrl = "https://katalon-demo-cura.herokuapp.com/";
        String url1 = actualUrl.equals(expectedUrl)?"url passed":"url failed";
        System.out.println(url1);
        driver.close();










    }
}
