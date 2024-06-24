package performance.upskilling.atf.configuration.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class WebDriverWaiter {
    private static final int DEFAULT_TIMEOUT = 10; // Default timeout in seconds
    private static WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(WebDriverWaiter.class);

    public static WebDriverWait getWaiter(WebDriver driver) {
        if (wait == null) {
            try {
                logger.debug("Initializing WebDriverWait with timeout of {} seconds", DEFAULT_TIMEOUT);
                wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
                logger.info("WebDriverWait initialized with default timeout");
            } catch (Exception e) {
                logger.error("Error initializing WebDriverWait: {}", e.getMessage());
            }
        }
        return wait;
    }
}
