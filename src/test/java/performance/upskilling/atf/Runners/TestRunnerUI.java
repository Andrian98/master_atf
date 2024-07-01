package performance.upskilling.atf.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"performance.upskilling.atf.ui", "performance.upskilling.atf.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = "@Orange_UI"
)

public class TestRunnerUI {
}
