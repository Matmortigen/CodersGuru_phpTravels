package CodersGuru;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class registrationCodersGuru {

    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
    private static final SecureRandom RANDOM = new SecureRandom();

    public String generate(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }

    private String email;
    private String firstName;
    private String lastName;
    private String passwordFirst;
    private String passwordSecond;
    private String city;
    private String postalCode;
    private String street;
    private String number;


    private WebDriver driver;

    @Given("^Go to the CodersGuru home page$")
    public void GoToTheCodersGuruHomePage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://tester.codersguru.pl/");
    }


    @And("^On the main page click the create account button$")
    public void onTheMainPageClickTheCreateAccountButton() {
        WebElement createAnAccount = driver.findElement(By.xpath("/html/body/section[3]/div/form/input[2]"));
        createAnAccount.click();
    }

    @When("^Complete all user registration fields (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*)$")
    public void completeAllUserRegistrationFields(String email, String firstName, String lastName, String passwordFirst, String passwordSecond, String city, String postalCode, String street, String number) {
        WebElement person = driver.findElement(By.id("person"));
        person.click();

        WebElement putAddressEmail = driver.findElement(By.id("fos_user_registration_form_email"));
        this.email = generate(6) + email;
        putAddressEmail.sendKeys(this.email);

        WebElement putFirstName = driver.findElement(By.id("fos_user_registration_form_name"));
        putFirstName.sendKeys(firstName);

        WebElement putLastName = driver.findElement(By.id("fos_user_registration_form_lastname"));
        putLastName.sendKeys(lastName);

        WebElement putPasswordFirst = driver.findElement(By.id("fos_user_registration_form_plainPassword_first"));
        putPasswordFirst.sendKeys(passwordFirst);

        WebElement putPasswordSecond = driver.findElement(By.id("fos_user_registration_form_plainPassword_second"));
        putPasswordSecond.sendKeys(passwordSecond);

        WebElement fromCity = driver.findElement(By.id("form_city"));
        fromCity.sendKeys(city);

        WebElement putPostalCode = driver.findElement(By.id("form_postal_code"));
        putPostalCode.sendKeys(postalCode);

        WebElement putStreet = driver.findElement(By.id("form_street"));
        putStreet.sendKeys(street);

        WebElement putNumber = driver.findElement(By.id("form_number"));
        putNumber.sendKeys(number);

        WebElement regulationsCheckbox = driver.findElement(By.xpath("//*[@id='registration-main-form']/div[12]/input"));
        regulationsCheckbox.click();
    }

    @And("^Clicking the register button$")
    public void clickingTheRegisterButton() {
        WebElement register = driver.findElement(By.id("register-submit-btn"));
        register.click();
    }

    @Then("^We log out the newly registered user$")
    public void weLogOutTheNewlyRegisteredUser() {

        WebElement userPanel = driver.findElement(By.xpath("/html/body/section[1]/div/div[3]/a/img"));
        userPanel.click();

        WebElement addressEmail = driver.findElement(By.id("email"));
        addressEmail.getText();

        String emailToVerify = addressEmail.getText();
        Assert.assertEquals(this.email, emailToVerify);

        WebElement log = driver.findElement(By.xpath("/html/body/section[3]/div/div/a/button"));
        log.click();
    }

    @And("^We log in again to the newly created user confirming correct registration$")
    public void weLogInAgainToTheNewlyCreatedUserConfirmingCorrectRegistration() {
        WebElement userPanel = driver.findElement(By.name("button"));
        userPanel.click();

        WebElement putUsername = driver.findElement(By.id("username"));
        putUsername.sendKeys(this.email);

        WebElement putPassword = driver.findElement(By.id("password"));
        putPassword.sendKeys("qwerty123456");

        WebElement submit = driver.findElement(By.id("_submit"));
        submit.click();

        WebElement userPanelSecondTime = driver.findElement(By.xpath("/html/body/section[1]/div/div[3]/a/img"));
        userPanelSecondTime.click();
    }

    @And("^Close the browser window$")
    public void closeTheBrowserWindow() {
        driver.quit();
    }
}
