package performance.upskilling.atf.Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/admin_user_management.feature"},
        glue = {"performance.upskilling.atf.api"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class TestRunnerAPI {
}
