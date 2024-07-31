package performance.upskilling.atf.ui.pagesimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pageobjects.LoginPageElements;
import performance.upskilling.atf.ui.pageobjects.OverviewPageElements;
import performance.upskilling.atf.util.TestCustomActions;

public class LoginPageImpl {
    public WebDriver driver;
    public static WebDriverWait wait;
    public static final Logger logger = LogManager.getLogger();
    private static final TestCustomActions testCustomActions = new TestCustomActions();
    private final LoginPageElements loginPageElements = new LoginPageElements();
    public static OverviewPageElements overviewPageElements = new OverviewPageElements();

    public LoginPageImpl() {
        this.driver = WebDriverManager.getDriver();
        wait = WebDriverWaiter.getWaiter(driver);
    }

    //TODO put the elements in the Impl class for the better performance
    public void userLogin() {
        testCustomActions.sendKeysToWebElement(loginPageElements.getUsername(), PropertiesManager.getUsername());
        testCustomActions.sendKeysToWebElement(loginPageElements.getPassword(), PropertiesManager.getPassword());
        logger.info("User inserted valid credentials");
    }

    public void userClickSubmit() {
        testCustomActions.clickButton(loginPageElements.getSubmit());
        logger.info("User clicked on submit button");
    }

    public void validateWelcomeMessage() {
        String welcomeMessage = testCustomActions.getTextFromPage(overviewPageElements.getWelcomeMessage());
        logger.debug("{} message displayed", welcomeMessage);
    }

}
