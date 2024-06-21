package performance.upskilling.atf.configuration.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WebDriverManager {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(WebDriverManager.class);

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                logger.debug("Setting system property for ChromeDriver");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

                logger.debug("Initializing ChromeDriver");
                driver = new ChromeDriver();
                driver.manage().window().maximize();

                logger.info("ChromeDriver initialized and window maximized");
            } catch (Exception e) {
                logger.error("Error initializing ChromeDriver: {}", e.getMessage());
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            try {
                logger.debug("Quitting ChromeDriver");
                driver.quit();
                driver = null;
                logger.info("ChromeDriver quit successfully");
            } catch (Exception e) {
                logger.error("Error quitting ChromeDriver: {}", e.getMessage());
            }
        }
    }
}
