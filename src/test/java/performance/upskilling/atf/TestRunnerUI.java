package performance.upskilling.atf;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"performance/upskilling/atf/ui", "performance/upskilling/atf/hooks"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)

public class TestRunnerUI {

    private static final Logger logger = LogManager.getLogger(TestRunnerUI.class);

    @AfterClass
    public static void tearDownAfterAllScenarios() {
        logger.info("All the scenarios were executed. ");
        WebDriverManager.quitDriver();
        logger.debug("Browser is closed.");
    }
}
