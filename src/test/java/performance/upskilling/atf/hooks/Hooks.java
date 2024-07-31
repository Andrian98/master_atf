package performance.upskilling.atf.hooks;

import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.steps.RegistrationPageSteps;
import performance.upskilling.atf.util.TestCustomActions;
import performance.upskilling.atf.util.TestPreconditions;


public class Hooks {
    private static final Logger logger = LogManager.getLogger();
    private static final TestPreconditions testPreconditions = new TestPreconditions();
    private static final TestCustomActions testCustomActions = new TestCustomActions();
    private static Boolean uiTestExecution = false;

    @BeforeAll()
    public static void setPreconditions() {
        testPreconditions.validateAdminSetUp();
        testCustomActions.navigateTo(PropertiesManager.getRegisterURL());
        testPreconditions.userRegistration();

        WebDriverManager.quitDriver();
        logger.info("Browser closed after setting preconditions for tests.");
    }

    @Before(value = "@UI")
    public void launchBrowserForPreconditions() {
        WebDriverManager.getDriver();
        uiTestExecution = true;
        logger.info("Launching browser for UI test.");
    }

    @Before(value = "@UI")
    public void getDesktopSizeForPreconditions() {
        WebDriverManager.getMonitorResolution();
    }
    //TODO scenario context for preconditions

    @Before(value = "@API")
    public void beforeAPITest() {
        TestCustomActions.setRestAssured(PropertiesManager.getLoginURL());
        logger.info("Started the API test.");
    }

    @AfterAll
    public static void afterAll() {
        if (uiTestExecution) {
            WebDriverManager.quitDriver();
        }
        logger.info("Browser closed. All tests executed.");
    }

}
