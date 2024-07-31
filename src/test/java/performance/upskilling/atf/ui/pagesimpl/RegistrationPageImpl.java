package performance.upskilling.atf.ui.pagesimpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.ui.pageobjects.RegistrationPageElements;
import performance.upskilling.atf.util.TestCustomActions;

import java.util.Map;

public class RegistrationPageImpl {
    private static final Logger logger = LogManager.getLogger();
    public WebDriver driver;
    public static WebDriverWait wait;
    private static final TestCustomActions testCustomActions = new TestCustomActions();
    public RegistrationPageElements registrationPageElements = new RegistrationPageElements();

    public RegistrationPageImpl() {
        this.driver = WebDriverManager.getDriver();
        wait = WebDriverWaiter.getWaiter(driver);
    }

    public void insertRegisterDetails(Map<String, String> userDetails) {

        for (Map.Entry<String, String> entry : userDetails.entrySet()) {
            String fieldName = entry.getKey();
            String value = entry.getValue();

            WebElement webElement = registrationPageElements.getElement(fieldName);
            if (webElement != null) {
                testCustomActions.sendKeysToWebElement(webElement, value);
            } else {
                logger.error("Element with field name '{}' not found.", fieldName);
            }
        }
        logger.info("User entered register credentials");
    }

    public String validateUserCreation() {
        String actualMessage = registrationPageElements.getValidateUserCreation().getText();
        logger.info("{}", actualMessage);
        return actualMessage;
    }
}
