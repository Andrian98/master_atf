package performance.upskilling.atf.configuration.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum BrowserType {
    CHROME {
        @Override
        public WebDriver createDriver() {
            return new ChromeDriver(); // Instantiate ChromeDriver
        }
    },
    FIREFOX {
        @Override
        public WebDriver createDriver() {
            return new FirefoxDriver(); // Instantiate FirefoxDriver
        }
    },
    EDGE {
        @Override
        public WebDriver createDriver() {
            return new EdgeDriver(); // Instantiate EdgeDriver
        }
    };

    // Abstract method to be implemented by each enum constant
    public abstract WebDriver createDriver();
}
