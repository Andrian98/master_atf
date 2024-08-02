package performance.upskilling.atf.ui.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.util.TestCustomActions;

public class LoginPageElements {
    private WebDriver driver;
    private WebDriverWait wait;
    public static final Logger logger = LogManager.getLogger();
    private static final TestCustomActions testCustomActions = new TestCustomActions();
    public static OverviewPageElements overviewPageElements = new OverviewPageElements();

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submit;

    public LoginPageElements() {
        this.driver = WebDriverManager.getDriver();
        this.wait = WebDriverWaiter.getWaiter(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSubmit() {
        return submit;
    }

    public void userLogin() {
        testCustomActions.sendKeysToWebElement(getUsername(), PropertiesManager.getUsername());
        testCustomActions.sendKeysToWebElement(getPassword(), PropertiesManager.getPassword());
        logger.info("User inserted valid credentials");
    }

    public void userClickSubmit() {
        testCustomActions.clickButton(getSubmit());
        logger.info("User clicked on submit button");
    }

    public void validateWelcomeMessage() {
        String welcomeMessage = testCustomActions.getTextFromPage(overviewPageElements.getWelcomeMessage());
        logger.debug("{} message displayed", welcomeMessage);
    }
}
