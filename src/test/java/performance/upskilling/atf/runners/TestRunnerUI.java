package performance.upskilling.atf.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/ui/"},
        tags = "UI",
        glue = {"performance.upskilling.atf.ui", "performance.upskilling.atf.hooks"},
        stepNotifications = true,
        plugin = {"html:target/working-directory/reportUI"}
)

public class TestRunnerUI {
}
