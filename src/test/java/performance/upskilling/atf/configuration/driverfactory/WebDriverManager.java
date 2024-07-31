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
    private static final String browser = PropertiesManager.getBrowser();

    //TODO change the switch method here to something else
    public static WebDriver getDriver() {
        if (driver == null) {
            try{
            BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());
            driver = browserType.createDriver();
            logger.debug("Driver {} was started.", browserType.name());

            } catch (IllegalArgumentException e) {
                logger.debug("Unsupported browser: {}. Using Chrome as default.", browser);
                driver = BrowserType.CHROME.createDriver();
            }
            logger.info("WebDriver initialized");
        }
        return driver;
    }

    public static void getMonitorResolution(){
        driver.manage().window().maximize();
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
