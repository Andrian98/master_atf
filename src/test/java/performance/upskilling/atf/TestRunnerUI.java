package performance.upskilling.atf;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"performance/upskilling/atf/ui"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class TestRunnerUI {
}
