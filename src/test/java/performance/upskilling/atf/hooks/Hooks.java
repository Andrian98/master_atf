package performance.upskilling.atf.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.util.TestUtils;

public class Hooks {

    private static final Logger logger = LogManager.getLogger();
    // TODO webdriver in singlton, failfast to stop the test if exception
    // TODO parametrised the hooks, study in test-materials

    @Before("@API")
    public static void beforeAPITest() {
        TestUtils.setRestAssured(PropertiesManager.getIndexURL());
    }

    @Before("@UI")
    public void launchBrowser() {
        logger.info("Starting the UI test.");
            WebDriverManager.getDriver();
    }

    @After("@UI")
    public static void tearDownAfterAllScenarios() {
        logger.info("All the scenarios were executed. ");
        WebDriverManager.quitDriver();
        logger.info("Browser is closed.");
    }
}
