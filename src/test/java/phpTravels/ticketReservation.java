package phpTravels;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class ticketReservation {

    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
    private static final SecureRandom RANDOM = new SecureRandom();

    public String generate(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }

    private static final String NUMBERS = "0123456789";
    private static final SecureRandom RANDOMNUMBER = new SecureRandom();

    public String generateNumber(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            sb.append(NUMBERS.charAt(RANDOMNUMBER.nextInt(NUMBERS.length())));
        }
        return sb.toString();
    }

    private WebDriver driver;
    private String storedValueName;
    private String storedValueSurname;
    private String storedValueEmail;
    private String storedValuePhone;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.phptravels.net/index.php");
    }


    @Test
    public void tearDown() throws Exception {

        // Button My Account
        WebElement myAccount = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div[2]/div/ul/li[3]/div/a"));
        myAccount.click();

        // Link Sign Up
        WebElement signUp = driver.findElement(By.xpath("//*[@id='header-waypoint-sticky']/div[1]/div/div/div[2]/div/ul/li[3]/div/div/div/a[2]"));
        signUp.click();

        // New User Name Field
        WebElement firstName = driver.findElement(By.xpath("//*[@id='headersignupform']/div[3]/input"));
        this.storedValueName = (generate(5));
        firstName.sendKeys(this.storedValueName);

        // New User Last Name Field
        WebElement lastName = driver.findElement(By.xpath("//*[@id='headersignupform']/div[4]/input"));
        this.storedValueSurname = (generate(8));
        lastName.sendKeys(this.storedValueSurname);

        // New User Phone Number Field
        WebElement mobilePhone = driver.findElement(By.xpath("//*[@id='headersignupform']/div[5]/input"));
        this.storedValuePhone = (generateNumber(9));
        mobilePhone.sendKeys(this.storedValuePhone);

        // New User Eamil Address Field
        WebElement email = driver.findElement(By.xpath("//*[@id='headersignupform']/div[6]/input"));
        this.storedValueEmail = (generate(6) + "@gmail.com");
        email.sendKeys(this.storedValueEmail);

        // User Password
        WebElement password = driver.findElement(By.xpath("//*[@id='headersignupform']/div[7]/input"));
        password.sendKeys("Wiosna2020");

        // Repeat Password Field
        WebElement confirmPassword = driver.findElement(By.xpath("//*[@id='headersignupform']/div[8]/input"));
        confirmPassword.sendKeys("Wiosna2020");

        // Button Sign Up
        WebElement signUp2 = driver.findElement(By.xpath("//*[@id='headersignupform']/div[9]/button"));
        signUp2.click();


        // Link To Flight Booking Page
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement flights = driver.findElement(By.xpath("//*[@id='mobileMenuMain']/nav/ul/li[1]/a"));
        flights.click();


        // Flight Booking
        WebElement flights2 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div/nav/ul/li[2]/a"));
        flights2.click();

        // Flight In Both Directions
        WebElement roundTrip = driver.findElement(By.xpath("//*[@id='flights']/div/div/form/div/div[1]/div[1]/div[2]/label"));
        roundTrip.click();

        // Flight From Warsaw
        WebElement originElement = driver.findElement(By.id("s2id_location_from"));
        originElement.click();
        WebElement originOpenedElement = driver.findElement(By.xpath("//*[@id='select2-drop']//input"));
        originOpenedElement.clear();
        originOpenedElement.sendKeys("Warsaw");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.attributeContains(
                By.xpath("//*[@id='select2-drop']/ul/li[1]/div"), "innerText", "Warsaw"));
        driver.findElement(By.xpath("//*[@id='select2-drop']/ul/li[1]/div")).click();

        // Flight From New York
        WebElement originElement2 = driver.findElement(By.id("s2id_location_to"));
        originElement2.click();
        WebElement originOpenedElement2 = driver.findElement(By.xpath("//*[@id='select2-drop']//input"));
        originOpenedElement2.clear();
        originOpenedElement2.sendKeys("New York");
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.attributeContains(
                By.xpath("//*[@id='select2-drop']/ul/li[1]/div"), "innerText", "New York"));
        driver.findElement(By.xpath("//*[@id='select2-drop']/ul/li[1]/div")).click();

        // Calendar Flights Depart
        WebElement calendarDepart = driver.findElement(By.xpath("//*[@id='FlightsDateStart']"));
        calendarDepart.click();

        // Selection From December 2019 To January 2020
        WebElement calendarDepartJanuary = driver.findElement(By.xpath("//*[@id='datepickers-container']/div[7]/nav/div[3]"));
        calendarDepartJanuary.click();

        // Setting The Date To January 24, 2020
        WebElement calendarDepartJanuary24 = driver.findElement(By.xpath("//*[@id='datepickers-container']/div[7]/div/div/div[2]/div[27]"));
        calendarDepartJanuary24.click();

        // Calendar Flights Return
        WebElement calendarReturn = driver.findElement(By.xpath("//*[@id='FlightsDateEnd']"));
        calendarReturn.click();

        // Setting The Date To January 31, 2020
        WebElement calendarReturnJanuary31 = driver.findElement(By.xpath("//*[@id='datepickers-container']/div[8]/div/div/div[2]/div[34]"));
        calendarReturnJanuary31.click();

        // Search
        WebElement searchFlight = driver.findElement(By.xpath("//*[@id='flights']/div/div/form/div/div[2]/div[4]/button"));
        searchFlight.click();

        // Search Results
        WebElement searchResults = driver.findElement(By.xpath("//*[@id='LIST']/li[1]/div/div[1]/div[2]/form[1]/div[2]/div/button"));
        searchResults.click();

        // Menu
        WebElement menuClass = driver.findElement(By.id("title"));
        Select title = new Select(menuClass);
        title.selectByVisibleText("Mrs.");

        // Passenger Name
        WebElement passengerName = driver.findElement(By.id("name"));
        passengerName.sendKeys(this.storedValueName);

        // Passenger Surname
        WebElement passengerSurname = driver.findElement(By.id("surname"));
        passengerSurname.sendKeys(this.storedValueSurname);

        // Passenger Email
        WebElement passengerEmail = driver.findElement(By.id("email"));
        passengerEmail.sendKeys(this.storedValueEmail);

        // Passenger Phone
        WebElement passengerPhone = driver.findElement(By.id("phone"));
        passengerPhone.sendKeys(this.storedValuePhone);

        // Passenger Birthday
        WebElement passengerBirthday = driver.findElement(By.id("birthday"));
        passengerBirthday.sendKeys("1998" + "-" + "10" + "-" + "26");

        // Passenger Passport
        WebElement passengerPassport = driver.findElement(By.id("cardno"));
        passengerPassport.sendKeys(generateNumber(10));

        // Passenger Expiration Date
        WebElement passengerExpirationDate = driver.findElement(By.id("expiration"));
        passengerExpirationDate.sendKeys("2022" + "-" + "03" + "-" + "12");

        // Passenger Nationality
        WebElement passengerNationality = driver.findElement(By.xpath("//*[@id='s2id_nationality']/a"));
        passengerNationality.click();
        WebElement passengerNationalityClicked = driver.findElement(By.xpath("//*[@id='select2-drop']/div/input"));
        passengerNationality.sendKeys("POLAND");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='select2-drop']/ul/li/div")).click();

        // Payment Types
        WebElement menuTypeCard = driver.findElement(By.id("cardtype"));
        Select cardtype = new Select(menuTypeCard);
        cardtype.selectByVisibleText("MasterCard");

        // Card Number
        WebElement cardNumber = driver.findElement(By.id("card-number"));
        cardNumber.sendKeys(generateNumber(16));

        // Expiry Month Card
        WebElement menuCardExpirationMonth = driver.findElement(By.id("expiry-month"));
        Select expirymonth = new Select(menuCardExpirationMonth);
        expirymonth.selectByVisibleText("July (07)");

        // Expiry Year Card
        WebElement menuCardExpirationYear = driver.findElement(By.id("expiry-year"));
        Select expiryyear = new Select(menuCardExpirationYear);
        expiryyear.selectByVisibleText("2023");

        // Card Number CVV
        WebElement cardNumberCVV = driver.findElement(By.id("cvv"));
        cardNumberCVV.sendKeys(generateNumber(3));

        // Rules and Restriction
        WebElement rules = driver.findElement(By.xpath("//*[@id='acceptTerm']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", rules);

        // Button to Booking
        WebElement confirmBooking = driver.findElement(By.xpath("//*[@id='confirmBooking']"));
        JavascriptExecutor js2 = (JavascriptExecutor)driver;
        js2.executeScript("arguments[0].click();", confirmBooking);

        // Screenshot
//        takeSnapShot(driver, "C:\\Users\\MATMORTIGEN\\Desktop\\Egzamin ISTQB Pytania") ;

    }

//    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
//
//        //Convert web driver object to TakeScreenshot
//        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//
//        //Call getScreenshotAs method to create image file
//        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//
//        //Move image file to new destination
//        File DestFile=new File(fileWithPath);
//
//        //Copy file at destination
//        FileUtils.copyFile(SrcFile, DestFile);
//
//    }

    @After
    public void fillFormTest() {
        driver.quit();
    }

}
