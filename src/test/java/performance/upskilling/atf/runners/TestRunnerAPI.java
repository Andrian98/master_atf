package performance.upskilling.atf.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/api/"},
        glue = {"performance.upskilling.atf.api", "performance.upskilling.atf.hooks"},
        plugin = {"pretty", "html:target/test-reports/reportAPI"},
        tags = "@API",
        stepNotifications = true
)

public class TestRunnerAPI {
}
