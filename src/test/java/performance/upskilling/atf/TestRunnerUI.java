package performance.upskilling.atf;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"performance/upskilling/atf/ui", "performance/upskilling/atf/hooks"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class TestRunnerUI {
    @AfterClass
    public static void tearDownAfterAllScenarios() {
        WebDriverManager.quitDriver();
    }
}
