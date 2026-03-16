package performance.upskilling.atf.configuration.enums;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public enum BrowserType {
    CHROME {
        @Override
        public WebDriver createDriver() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--disable-cache");
            return new ChromeDriver(options);
        }
    },
    FIREFOX {
        @Override
        public WebDriver createDriver() {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");
            return new FirefoxDriver(options);
        }
    },
    EDGE {
        @Override
        public WebDriver createDriver() {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--inprivate");
            options.addArguments("--disable-cache");
            return new EdgeDriver(options);
        }
    };

    public abstract WebDriver createDriver();
}
