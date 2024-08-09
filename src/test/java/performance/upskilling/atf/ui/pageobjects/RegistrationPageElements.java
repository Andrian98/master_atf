package performance.upskilling.atf.ui.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;
import performance.upskilling.atf.util.TestCustomActions;

import java.util.HashMap;
import java.util.Map;

public class RegistrationPageElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger();
    private static final TestCustomActions testCustomActions = new TestCustomActions();

    @FindBy(id = "customer.firstName")
    private WebElement firstNameField;

    @FindBy(id = "customer.lastName")
    private WebElement lastNameField;

    @FindBy(id = "customer.address.street")
    private WebElement addressField;

    @FindBy(id = "customer.address.city")
    private WebElement cityField;

    @FindBy(id = "customer.address.state")
    private WebElement stateField;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipField;

    @FindBy(id = "customer.ssn")
    private WebElement ssnField;

    @FindBy(id = "customer.username")
    private WebElement usernameField;

    @FindBy(id = "customer.password")
    private WebElement passwordField;

    @FindBy(id = "repeatedPassword")
    private WebElement confirmField;

    @FindBy(xpath = "(//input[@class='button'])[2]")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@id='rightPanel']//p[1]")
    private WebElement validateUserCreation;

    @FindBy(linkText = "Log Out")
    private WebElement logOutButton;

    private final Map<String, WebElement> elementsMap;

    public RegistrationPageElements() {
        this.driver = WebDriverManager.getDriver();
        this.wait = WebDriverWaiter.getWaiter(driver);
        PageFactory.initElements(driver, this);

        // Initialize the map and add all WebElements with their field names as keys
        elementsMap = new HashMap<>();
        elementsMap.put("First Name", firstNameField);
        elementsMap.put("Last Name", lastNameField);
        elementsMap.put("Address", addressField);
        elementsMap.put("City", cityField);
        elementsMap.put("State", stateField);
        elementsMap.put("Zip Code", zipField);
        elementsMap.put("SSN", ssnField);
        elementsMap.put("Username", usernameField);
        elementsMap.put("Password", passwordField);
        elementsMap.put("Confirm", confirmField);
    }

    public WebElement getElement(String fieldName) {
        return elementsMap.get(fieldName);
    }

    public WebElement getValidateUserCreation() {
        return validateUserCreation;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public WebElement getLogOutButton() {
        return logOutButton;
    }

    public void insertRegisterDetails(Map<String, String> userDetails) {

        for (Map.Entry<String, String> entry : userDetails.entrySet()) {
            String fieldName = entry.getKey();
            String value = entry.getValue();

            WebElement webElement = getElement(fieldName);
            if (webElement != null) {
                testCustomActions.sendKeysToWebElement(webElement, value);
            } else {
                logger.error("Element with field name '{}' not found.", fieldName);
            }
        }
        logger.info("User entered register credentials");
    }

    public String validateUserCreation() {
        String actualMessage = getValidateUserCreation().getText();
        logger.info("{}", actualMessage);
        return actualMessage;
    }
}
