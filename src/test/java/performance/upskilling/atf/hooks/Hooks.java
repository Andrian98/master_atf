package performance.upskilling.atf.hooks;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.steps.RegistrationPageSteps;
import performance.upskilling.atf.util.TestCustomActions;
import performance.upskilling.atf.util.TestPreconditions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hooks {

    private static final Logger logger = LogManager.getLogger();
    private static final TestPreconditions testPreconditions = new TestPreconditions(WebDriverManager.getDriver());
    private final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();
    private static boolean isPreconditionsExecuted = false;


    @Before(order = 1)
    public void launchBrowserForPreconditions() {
        if (!isPreconditionsExecuted) {
            WebDriverManager.getDriver();
            logger.info("Launching browser for preconditions.");
        }
    }

    @Before(order = 2)
    public void getDesktopSizeForPreconditions() {
        if (!isPreconditionsExecuted) {
            WebDriverManager.getMonitorResolution();
        }
    }

    @Before(order = 3)
    public void setPreconditions(Scenario scenario) {
        if (!isPreconditionsExecuted) {
            testPreconditions.validateAdminSetUp();
            logger.info("Preconditions executed.");
            isPreconditionsExecuted = true;

            logger.info("Starting UI test");

            // Close the browser after preconditions are set if the test is an API test
            if (scenario.getSourceTagNames().contains("@API")) {
                registrationPageSteps.userIsOnRegistrationPage();
                testPreconditions.userRegistration();

                WebDriverManager.quitDriver();
                logger.info("Browser closed after setting preconditions for API test.");
            }
        }
    }

//    @Before(order = 4)
//    public void launchBrowserForUITest(Scenario scenario) {
//        if (scenario.getSourceTagNames().contains("@UI")) {
//            WebDriverManager.getDriver();
//            logger.info("Started the UI test.");
//        }
//    }
//
//    @Before(order = 5)
//    public void getDesktopSizeForUITest(Scenario scenario) {
//        if (scenario.getSourceTagNames().contains("@UI")) {
//            WebDriverManager.getMonitorResolution();
//        }
//    }

    @Before(order = 6, value = "@API")
    public void beforeAPITest() {
        TestCustomActions.setRestAssured(PropertiesManager.getLoginURL());
        logger.info("Started the API test.");
    }


//    @BeforeAll
//    public static void beforeAll() {
//        testPreconditions.validateAdminSetUp();
//        WebDriverManager.quitDriver();
//        logger.info("Before All preconditions were executed");
//    }

//    @Before("@API")
//    public static void beforeAPITest() {
//        TestCustomActions.setRestAssured(PropertiesManager.getLoginURL());
//    }
//
//    @Before(order = 1, value = "@UI")
//    public void launchBrowser() {
//        WebDriverManager.getDriver();
//        logger.info("Started the UI test.");
//    }
//
//    @Before(order = 2, value = "@UI")
//    public static void getDesktopSize() {
//        WebDriverManager.getMonitorResolution();
//    }

    @AfterAll
    public static void afterAll() {
        WebDriverManager.quitDriver();
        logger.info("Browser closed. All tests executed.");
    }

//    @After("@UI")
//    public static void tearDownAfterAllScenarios() {
//        logger.info("All the scenarios were executed. ");
//        WebDriverManager.quitDriver();
//        logger.info("Browser is closed.");
//    }
}
