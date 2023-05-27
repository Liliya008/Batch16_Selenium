package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomeWork {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);

        driver.get("https://www.zara.com/us/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "ZARA United States | New Collection Online";
        String title1= actualTitle.equals(expectedTitle)?"Zara Title Passed":"Zara Title Failed";
        System.out.println(title1);


        String actualUrl= driver.getCurrentUrl();
        String expectedUrl = "https://www.zara.com/us/";
        String url1 = actualUrl.equals(expectedUrl)?"Zara url passed":"Zara url failed";
        System.out.println(url1);
        driver.close();
        System.out.println("===============================");

        driver=new ChromeDriver(chromeOptions);
        driver.get("https://oldnavy.gap.com/");
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Old Navy | Shop the Latest Fashion for the Whole Family";
        String title2 = actualTitle.equals(expectedTitle)?"OldNavy Title Passed":"OldNavy Title Failed";
        System.out.println(title2);

        String actualUrl2= driver.getCurrentUrl();
        String expectedUrl2 = "https://oldnavy.gap.com/";
        String url2 = actualUrl.equals(expectedUrl)?"OldNavy url passed":"OldNavy url failed";
        System.out.println(url2);
        driver.close();
        System.out.println("===============================");

        driver=new ChromeDriver(chromeOptions);
        driver.get("https://www2.hm.com/en_us/index.html");
        String actualTitle3 = driver.getTitle();
        String expectedTitle3 = "H&M | Online Fashion, Homeware & Kids Clothes | H&M US";
        String title3= actualTitle.equals(expectedTitle)?"H&M Title Passed":"H&M Title Failed";
        System.out.println(title3);

        String actualUrl3= driver.getCurrentUrl();
        String expectedUrl3 = "https://www2.hm.com/en_us/index.html";
        String url3 = actualUrl.equals(expectedUrl)?"H&M url passed":"H&M url failed";
        System.out.println(url3);
        driver.close();
        System.out.println("===============================");
    }
}
