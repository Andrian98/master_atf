package performance.upskilling.atf.configuration.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\_perf\\performance_atf\\src\\main\\java\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }//end if
        return driver;
    }//end getDriver

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }//end quitDriver
}
