package SelectClass;

import Utils.BrowserUtils;
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
import java.util.Arrays;
import java.util.List;

public class SelectMidLevelPractice {
    @Test
    public void validateOrderMessage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        /*
        1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
         */
        WebElement flightType = driver.findElement(By.xpath("//input[@name='tripType']"));
        flightType.click();

        WebElement passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select choicePassengersNumber = new Select(passengers);
        choicePassengersNumber.selectByValue("4");

        WebElement departingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select choiceDepartingFrom = new Select(departingFrom);
        String actualDefaultDeparting = choiceDepartingFrom.getFirstSelectedOption().getText().trim();
        String expectedDefaulDeparting = "Acapulco";
        Assert.assertEquals(actualDefaultDeparting, expectedDefaulDeparting);

        choiceDepartingFrom.selectByVisibleText("Paris");

        WebElement DepartureMonthBox = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select choiceDepartureMonth = new Select(DepartureMonthBox);
        choiceDepartureMonth.selectByIndex(7);

        WebElement departureDateBox = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select choiceDepartureDate = new Select(departureDateBox);
        choiceDepartureDate.selectByVisibleText("15");

        WebElement arrivalCityBox = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select choiceCity = new Select(arrivalCityBox);
        choiceCity.selectByValue("San Francisco");

        WebElement arrivalMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select choiceArrivalMonth = new Select(arrivalMonth);
        choiceArrivalMonth.selectByVisibleText("December");

        WebElement arrivalDate = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select choiceArrivalDate = new Select(arrivalDate);
        choiceArrivalDate.selectByIndex(14);

        WebElement choiceServiceClass = driver.findElement(By.xpath("//input[@value='First']"));
        choiceServiceClass.click();

        WebElement airlineBox = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airline = new Select(airlineBox);
        List<WebElement> actualAirline = airline.getOptions();
        List<String> expectedAirline = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i = 0; i < actualAirline.size(); i++) {
            Thread.sleep(1000);
            Assert.assertEquals(actualAirline.get(i).getText().trim(), expectedAirline.get(i).trim());
        }
        airline.selectByVisibleText("Unified Airlines");
        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();


        WebElement messageOnTheTop = driver.findElement(By.xpath("//font[@size='4']"));
        Assert.assertEquals(messageOnTheTop.getText().trim(), "After flight finder - No Seats Available");
    }

    @Test
    public void validateOrderMessageShortCut() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        /*
        1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
         */
        WebElement flightType = driver.findElement(By.xpath("//input[@name='tripType']"));
        flightType.click();

        WebElement passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passengers, "4", "value");

        WebElement departingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select choiceDepartingFrom = new Select(departingFrom);
        String actualDefaultDeparting = choiceDepartingFrom.getFirstSelectedOption().getText().trim();
        String expectedDefaulDeparting = "Acapulco";
        Assert.assertEquals(actualDefaultDeparting, expectedDefaulDeparting);
        BrowserUtils.selectBy(departingFrom, "Paris", "text");

        WebElement DepartureMonthBox = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(DepartureMonthBox, "7", "index");

        WebElement departureDateBox = driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(departureDateBox, "15", "text");

        WebElement arrivalCityBox = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(arrivalCityBox, "San Francisco", "value");

        WebElement arrivalMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(arrivalMonth, "December", "text");

        WebElement arrivalDate = driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(arrivalDate, "14", "index");

        WebElement choiceServiceClass = driver.findElement(By.xpath("//input[@value='First']"));
        choiceServiceClass.click();

        WebElement airlineBox = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airline = new Select(airlineBox);
        List<WebElement> actualAirline = airline.getOptions();
        List<String> expectedAirline = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i = 0; i < actualAirline.size(); i++) {
            Thread.sleep(1000);
            Assert.assertEquals(BrowserUtils.getText(actualAirline.get(i)), expectedAirline.get(i).trim());
        }
        airline.selectByVisibleText("Unified Airlines");
        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();

        WebElement messageOnTheTop = driver.findElement(By.xpath("//font[@size='4']"));
        Assert.assertEquals(BrowserUtils.getText(messageOnTheTop), "After flight finder - No Seats Available");
    }


}