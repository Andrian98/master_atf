package performance.upskilling.atf.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import org.apache.logging.log4j.Logger;

public class TestHooks {

    private static final Logger logger = LogManager.getLogger(TestHooks.class);

    @Before
    public void launchBrowser() {
        logger.info("Starting the UI test.");
        try{
            logger.debug("Starting the browser");
            WebDriverManager.getDriver();
            logger.debug("Browser was lunched successfully.");
        } catch (Exception e){
            logger.error("Browser didn't start.", e);
        }

    }

    @After
    public void tearDown() {
//        try {
//            WebDriverManager.quitDriver();
//        } catch (Exception e) {
//            System.err.println("Error closing browser: " + e.getMessage());
//        }
    }//end tearDown
}
