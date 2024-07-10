package performance.upskilling.atf.configuration.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

public class WebDriverManager {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    private WebDriverManager() {}

    public static WebDriver getDriver() {
        String browser = PropertiesManager.getBrowser();
        // First check without synchronization
        if (driver == null) {
            // Synchronize on the class object to ensure only one thread can enter
            synchronized (WebDriverManager.class) {
                // Second check inside the synchronized block
                if (driver == null) {
                    try {
                        switch (browser.toLowerCase()) {
                            case "chrome":
                                driver = new ChromeDriver();
                                logger.info("Driver CHROME was started.");
                                break;
                            case "firefox":
                                driver = new FirefoxDriver();
                                logger.info("Driver FIREFOX was started.");
                                break;
                            case "edge":
                                driver = new EdgeDriver();
                                logger.info("Driver EDGE was started.");
                                break;
                            default:
                                logger.debug("Unsupported browser: {}. Using Chrome as default.", browser);
                                driver = new ChromeDriver();
                        }
                        driver.manage().window().maximize();
                        logger.info("WebDriver initialized and window maximized");
                    } catch (WebDriverException e) {
                        logger.error("Error initializing WebDriver: ", e);
                    }
                }
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            logger.info("ChromeDriver quit successfully");
        } else {
            logger.error("ChromeDriver was already closed or not initialized.");
        }
    }
}
