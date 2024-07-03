package performance.upskilling.atf.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/api/"},
        glue = {"performance.upskilling.atf.api", "performance.upskilling.atf.api.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = "@Login"
)

public class TestRunnerAPI {
}
