package performance.upskilling.atf.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.ui.htmlelements.RegistrationPageElements;
import performance.upskilling.atf.util.TestUtils;

import java.util.List;
import java.util.Map;

public class RegistrationPageImpl {
    private static final Logger logger = LogManager.getLogger(RegistrationPageImpl.class);
    public WebDriver driver;
    public static WebDriverWait wait;
    private static TestUtils testUtils = new TestUtils();
    private final RegistrationPageElements registrationPageElements = new RegistrationPageElements();

    public RegistrationPageImpl(WebDriver driver) {
        this.driver = driver;
        wait = WebDriverWaiter.getWaiter(driver);
    }

    public void navigateToRegistrationPage(String registrationPage) {
        logger.debug("Validating Registration URL: {}", registrationPage);
        driver.navigate().to(registrationPage);
        logger.info("Registration URL validated");
    }

    public void insertRegisterDetails(Map<String, String> userDetails) {
        logger.info("Entering register credentials");

        for (Map.Entry<String, String> entry : userDetails.entrySet()) {
            String fieldName = entry.getKey();
            String value = entry.getValue();

            WebElement element = registrationPageElements.getElement(fieldName);
            if (element != null) {
                testUtils.sendKeysToElement(element, value);
            } else {
                logger.error("Element with field name '{}' not found in the element {}", fieldName, element);
            }
        }
        logger.info("User entered register credentials");
    }

    public void clickRegisterButton() {
        registrationPageElements.getElement("clickRegisterButton").click();
        logger.info("Clicked on register button");
    }

    public void validateUserCreation() {
        //     wait.until(ExpectedConditions.visibilityOf(registrationPageElements.getValidateUserCreation()));
        logger.info("New user is created");
    }
}
