package performance.upskilling.atf.ui.hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import org.apache.logging.log4j.Logger;

public class UIHooks {

    private static final Logger logger = LogManager.getLogger(UIHooks.class);
    // TODO webdriver in singlton, failfast to stop the test if exception
    // TODO parametrised the hooks, study in test-materials
    // TODO remove some of the try/catch if necessary
    @Before
    public void launchBrowser() {
        logger.info("Starting the UI test.");
        try {
            logger.debug("Starting the browser");
            WebDriverManager.getDriver();
            logger.debug("Browser was lunched successfully.");
        } catch (Exception e) {
            logger.error("Browser didn't start.", e);
        }

    }

    @AfterAll
    public static void tearDownAfterAllScenarios() {
        logger.info("All the scenarios were executed. ");
        WebDriverManager.quitDriver();
        logger.debug("Browser is closed.");
    }
}
