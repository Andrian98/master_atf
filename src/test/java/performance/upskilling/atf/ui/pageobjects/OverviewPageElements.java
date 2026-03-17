package performance.upskilling.atf.ui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;

public class OverviewPageElements {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "smallText")
    private WebElement welcomeMessage;

    @FindBy(xpath = "//b[normalize-space()='Database Cleaned']" )
    private WebElement cleanUpMessage;

    public OverviewPageElements() {
        this.driver = WebDriverManager.getDriver();
        this.wait = WebDriverWaiter.getWaiter(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getWelcomeMessage() {
        return welcomeMessage;
    }

    public WebElement getCleanUpMessage() {return cleanUpMessage;}
}
