package performance.upskilling.atf.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;

public class TransferFundsImpl {
    public WebDriver driver;
    public static WebDriverWait wait;


    public TransferFundsImpl(WebDriver driver) {
        this.driver = driver;
        wait = WebDriverWaiter.getWaiter(driver);
    }
}
