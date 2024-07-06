package performance.upskilling.atf.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistrationPageImpl {
    private static final Logger logger = LogManager.getLogger(RegistrationPageImpl.class);
    public WebDriver driver;
    public static WebDriverWait wait;
    // TODO check study materials related to xpath to optimise here, page factory, singleton.

    By firstNameField = By.id("customer.firstName");
    By lastNameField = By.id("customer.lastName");
    By addressField = By.id("customer.address.street");
    By cityField = By.id("customer.address.city");
    By stateField = By.id("customer.address.state");
    By zipField = By.id("customer.address.zipCode");
    By ssnField = By.id("customer.ssn");
    By usernameField = By.id("customer.username");
    By passwordField = By.id("customer.password");
    By confirmField = By.id("repeatedPassword");
    By clickRegisterButton = By.xpath("(//input[@class='button'])[2]");
    By validateUserCreation = By.xpath("//p[text()='Your account was created successfully. You are now logged in.']");

    public RegistrationPageImpl(WebDriver driver) {
        this.driver = driver;
        wait = WebDriverWaiter.getWaiter(driver);
    }

    public void navigateToRegistrationPage(String registrationPage) {
        logger.debug("Validating Registration URL: {}", registrationPage);
        driver.navigate().to(registrationPage);
        logger.info("Registration URL validated");
    }

    public void insertRegisterDetails(String firstName, String lastName, String address, String city, String state, String zip, String ssn, String username, String password, String confirmPassword) {
        //TODO try to use map with values and then take what is needed
        logger.info("Entering register credentials");
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(zipField).sendKeys(zip);
        driver.findElement(ssnField).sendKeys(ssn);
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmField).sendKeys(confirmPassword);

        logger.info("User entered register credentials");
    }

    public void clickRegisterButton() {
        driver.findElement(clickRegisterButton).click();
    }

    public void validateUserCreation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(validateUserCreation));
        logger.info("New user is created");
    }
}
