package performance.upskilling.atf.ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pageobjects.LoginPageElements;
import performance.upskilling.atf.ui.pageobjects.OverviewPageElements;
import performance.upskilling.atf.util.TestCustomActions;

public class LoginPageImpl {
    public WebDriver driver;
    public static WebDriverWait wait;
    public static final Logger logger = LogManager.getLogger();
    private static final TestCustomActions TEST_CUSTOM_ACTIONS = new TestCustomActions();
    private final LoginPageElements loginPageElements = new LoginPageElements();
    public static OverviewPageElements overviewPageElements = new OverviewPageElements();

    public LoginPageImpl(WebDriver driver) {
        this.driver = driver;
        wait = WebDriverWaiter.getWaiter(driver);
    }

    //TODO put the elements in the Impl class for the better performance
//TODO separate methods but called in one method userLogin
    public void userLogin() {
        logger.info("User logs in");
        TEST_CUSTOM_ACTIONS.sendKeysToWebElement(loginPageElements.getUsername(), PropertiesManager.getUsername());
        TEST_CUSTOM_ACTIONS.sendKeysToWebElement(loginPageElements.getPassword(), PropertiesManager.getPassword());

        logger.info("User inserted his credentials");
    }

    public void userClickSubmit() {
        loginPageElements.getSubmit().click();
        logger.info("User clicked submit");
    }

    //TODO use the assert only from the Assert library (assert was here)
    public void validateWelcomeMessage() {
        overviewPageElements.getWelcomeMessage().isDisplayed();
        logger.info("Welcome message displayed");
    }

}
