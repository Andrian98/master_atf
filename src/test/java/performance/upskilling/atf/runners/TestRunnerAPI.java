package performance.upskilling.atf.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/api/"},
        glue = {"performance.upskilling.atf.api", "performance.upskilling.atf.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = "@Login or @NewAccount",
        stepNotifications = true
)

public class TestRunnerAPI {
}
