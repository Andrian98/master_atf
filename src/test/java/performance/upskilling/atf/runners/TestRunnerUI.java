package performance.upskilling.atf.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/ui/"},
        glue = {"performance.upskilling.atf.ui", "performance.upskilling.atf.ui.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = "@User_Register"
)

public class TestRunnerUI {
}
