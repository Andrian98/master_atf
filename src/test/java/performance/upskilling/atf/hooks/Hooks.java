package performance.upskilling.atf.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.util.TestUtils;

import static performance.upskilling.atf.configuration.driverfactory.WebDriverManager.driver;

public class Hooks {

    private static final Logger logger = LogManager.getLogger();

    @Before("@API")
    public static void beforeAPITest() {
        TestUtils.setRestAssured(PropertiesManager.getIndexURL());
    }

    @Before(order = 1, value = "@UI")
    public void launchBrowser() {
        logger.info("Starting the UI test.");
        WebDriverManager.getDriver();
    }

    @Before(order = 2, value = "@UI")
    public static void getDesktopSize() {
        WebDriverManager.getMonitorResolution();
    }

    @After("@UI")
    public static void tearDownAfterAllScenarios() {
        logger.info("All the scenarios were executed. ");
        WebDriverManager.quitDriver();
        logger.info("Browser is closed.");
    }
}
