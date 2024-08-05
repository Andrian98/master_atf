package performance.upskilling.atf.configuration.driverfactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebDriverManager {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger();
    private static final String browser = PropertiesManager.getBrowser();

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
        if(driver == null){
            throw new WebDriverException("Driver is not initialized");
        }else {
            driver.manage().window().maximize();
            logger.info("Driver window maximized");
        }
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

    public static void takeScreenShot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("HHmmss_ddMMyyyy").format(new Date());
        String screenshotDir = "evidence/screenshots";
        String screenshotPath = screenshotDir + File.separator + "screenshot_" + timestamp + ".png";

        try {
            Files.createDirectories(Paths.get(screenshotDir));
            Files.copy(srcFile.toPath(), Paths.get(screenshotPath));
            logger.info("Screenshot saved at {}", screenshotPath);
        } catch (IOException e) {
            logger.error("Failed to save screenshot: {}", e.getMessage());
        }
    }
}
