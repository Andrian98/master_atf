package performance.upskilling.atf.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.ui.pageobjects.RegistrationPageElements;
import performance.upskilling.atf.util.TestUtils;

import java.util.Map;

public class RegistrationPageImpl {
    private static final Logger logger = LogManager.getLogger();
    public WebDriver driver;
    public static WebDriverWait wait;
    private static final TestUtils testUtils = new TestUtils();
    private final RegistrationPageElements registrationPageElements = new RegistrationPageElements();

    public RegistrationPageImpl(WebDriver driver) {
        this.driver = driver;
        wait = WebDriverWaiter.getWaiter(driver);
    }

    public void insertRegisterDetails(Map<String, String> userDetails) {
        logger.info("Entering register credentials");

        for (Map.Entry<String, String> entry : userDetails.entrySet()) {
            String fieldName = entry.getKey();
            String value = entry.getValue();

            WebElement webElement = registrationPageElements.getElement(fieldName);
            if (webElement != null) {
                testUtils.sendKeysToWebElement(webElement, value);
            } else {
                logger.error("Element with field name '{}' not found.", fieldName);
            }
        }
        logger.info("User entered register credentials");
    }

    public void clickRegisterButton() {
        registrationPageElements.getClickRegisterButton().click();
        logger.info("Clicked on register button");
    }

    public String validateUserCreation() {
        String actualMessage = registrationPageElements.getValidateUserCreation().getText();
        logger.info("{}", actualMessage);
        return actualMessage;
    }
}
