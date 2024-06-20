package performance.upskilling.atf.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;

public class TestHooks {

    @Before
    public void launchBrowser() {
        WebDriverManager.getDriver();
    }

    @After
    public void tearDown() {
//        try {
//            WebDriverManager.quitDriver();
//        } catch (Exception e) {
//            System.err.println("Error closing browser: " + e.getMessage());
//        }
    }//end tearDown
}
