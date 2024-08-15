package performance.upskilling.atf.configuration.driverfactory;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.configuration.enums.BrowserType;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

public class WebDriverManager {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger();
    private static final String browser = PropertiesManager.getBrowser();

    public static synchronized WebDriver getDriver() {
        if (driver == null) {
            try {
                BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());
                driver = browserType.createDriver();
                logger.debug("Driver {} was started.", browserType.name());

            } catch (IllegalArgumentException e) {
                logger.debug("Unsupported browser: {}. Using Chrome as default.", browser);
                logger.error("Error Message {}", e.getMessage());
                driver = BrowserType.CHROME.createDriver();
            }
            logger.info("WebDriver initialized");
        }
        return driver;
    }

    public static void getMonitorResolution() {
            getDriver().manage().window().maximize();
            logger.info("Driver window maximized");
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            logger.info("WebDriver quit successfully");
        } else {
            logger.error("WebDriver was already closed or not initialized.");
        }
    }
}
