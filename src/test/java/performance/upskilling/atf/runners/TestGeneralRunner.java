package performance.upskilling.atf.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        tags = "@UI or @API",
        glue = {"performance.upskilling.atf.api", "performance.upskilling.atf.ui", "performance.upskilling.atf.hooks"},
        stepNotifications = true,
        plugin = {"html:target/working-directory/generalReport"}
)

public class TestGeneralRunner {

}
