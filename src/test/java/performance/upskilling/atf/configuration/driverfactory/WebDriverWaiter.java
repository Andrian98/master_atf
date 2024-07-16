package performance.upskilling.atf.configuration.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

import java.time.Duration;

public class WebDriverWaiter {
    private static final int defaultTimeOut = PropertiesManager.getDefaultTimeOut(); // Default timeout in seconds
    public static WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger();

    public static WebDriverWait getWaiter(WebDriver driver) {
        if (wait == null) {
            try {
                logger.debug("Initializing WebDriverWait with timeout of {} seconds", defaultTimeOut);
                wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeOut));
                logger.info("WebDriverWait initialized with default timeout");
            } catch (WebDriverException e) {
                logger.error("Error initializing WebDriverWait: {}", e.getMessage());
            }
        }
        return wait;
    }
}
