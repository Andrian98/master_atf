package performance.upskilling.atf.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverWaiter {
    private static final int DEFAULT_TIMEOUT = 10; // Default timeout in seconds
    private static WebDriverWait wait;

    public static WebDriverWait getWaiter(WebDriver driver) {
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        }
        return wait;
    }
}
