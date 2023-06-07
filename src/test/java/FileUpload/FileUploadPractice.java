package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void practice1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        //WebDriver driver= new ChromeDriver(); --> polymorphism
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("/Users/liliakappanova/Desktop/usa.webp");
        WebElement uploadButton = driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.submit();
        WebElement header = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(BrowserUtils.getText(header), "File Uploaded!");
        WebElement validateFileName = driver.findElement(By.cssSelector("#uploaded-files"));
        Assert.assertEquals(BrowserUtils.getText(validateFileName), "usa.webp");
    }
@Test
    public void practice2() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("remote-allow-origins=*");
    ChromeDriver driver = new ChromeDriver(chromeOptions);
    //WebDriver driver= new ChromeDriver(); --> polymorphism
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://demo.guru99.com/test/upload/");

    WebElement chooseFile = driver.findElement(By.cssSelector(".upload_txt"));
    chooseFile.sendKeys("/Users/liliakappanova/Desktop/usa.webp");
    WebElement selectFileValidateMessage = driver.findElement(By.xpath("//span[.='Select file to send(max 196.45 MB)']"));
    Assert.assertEquals(BrowserUtils.getText(selectFileValidateMessage),"Select file to send(max 196.45 MB)");
    WebElement acceptButton= driver.findElement(By.cssSelector("#terms"));
    if(acceptButton.isEnabled()&&acceptButton.isDisplayed()&&!acceptButton.isSelected()) {
        acceptButton.click();
    }
    WebElement submitFileButton =driver.findElement(By.xpath("//button[@name='send']"));
    submitFileButton.click();
    WebElement validateMessage =driver.findElement(By.xpath("//h3"));
    System.out.println();
    Thread.sleep(2000);
    Assert.assertEquals(BrowserUtils.getText(validateMessage),"1 file\n" +
            "has been successfully uploaded.");









}
    }
