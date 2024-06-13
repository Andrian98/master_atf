package performance.upskilling.atf.hooks;

import org.junit.After;
import org.junit.Before;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;

public class TestHooks {

    @Before
    public void launchBrowser() {
        WebDriverManager.getDriver();
    }

    @After
    public void tearDown() {
        WebDriverManager.quitDriver();
    }
}
