package performance.upskilling.atf.hooks;

import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pageobjects.RegistrationPageElements;
import performance.upskilling.atf.util.TestCustomActions;
import performance.upskilling.atf.util.TestPreconditions;
import performance.upskilling.atf.util.TestUtils;


public class Hooks {
    private static final Logger logger = LogManager.getLogger();
    private static final TestPreconditions testPreconditions = new TestPreconditions();
    private static final TestCustomActions testCustomActions = new TestCustomActions();
    private static Boolean uiTestExecution = false;
    public RegistrationPageElements registrationPageElements = new RegistrationPageElements();

    static {
        // Register the shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(TestUtils::addEvidence));
    }

    @BeforeAll()
    public static void setPreconditions() {
        TestUtils.createEvidenceDirectory();
        TestUtils.cleanUpOldEvidence();
        testPreconditions.validateAdminSetUp();
        testCustomActions.navigateTo(PropertiesManager.getRegisterURL());
        testPreconditions.registerNewUser();

        WebDriverManager.quitDriver();
        logger.info("Browser closed after setting preconditions for tests.");
    }

    @Before("@UI")
    public void launchBrowserForPreconditions() {
        WebDriverManager.getDriver();
        uiTestExecution = true;
        logger.info("Launching browser for UI test.");
    }

    @Before("@UI")
    public void getDesktopSizeForPreconditions() {
        WebDriverManager.getMonitorResolution();
    }

    @Before("@API")
    public void beforeAPITest() {
        TestCustomActions.setRestAssured(PropertiesManager.getLoginURL());
        logger.info("Started the API test.");
    }

    @After("@UI")
    public void afterUIScenarios(){
        testCustomActions.clickButton(registrationPageElements.getLogOutButton());
    }

    @AfterStep("@UI")
    public static void testEvidence(Scenario scenario) {
        TestUtils.addScreenshotsToReport(scenario);
        logger.info("Screenshot saved in evidence.");
    }

    @AfterAll
    public static void afterAll() {
        if (uiTestExecution) {
            WebDriverManager.quitDriver();
        }
        logger.info("Browser closed. All tests executed.");
    }

}
