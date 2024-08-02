package performance.upskilling.atf.ui.pagesimpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;

public class TransferFundsImpl {
    public WebDriver driver;
    public static WebDriverWait wait;


    public TransferFundsImpl() {
        this.driver = WebDriverManager.getDriver();
        wait = WebDriverWaiter.getWaiter(driver);
    }
}
