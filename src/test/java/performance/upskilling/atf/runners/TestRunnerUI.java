package performance.upskilling.atf.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/ui/"},
        glue = {"performance.upskilling.atf.ui", "performance.upskilling.atf.hooks"},
        plugin = {"pretty", "html:target/test-reports/reportUI"},
        tags = "@UI",
        stepNotifications = true
)

public class TestRunnerUI {
}
