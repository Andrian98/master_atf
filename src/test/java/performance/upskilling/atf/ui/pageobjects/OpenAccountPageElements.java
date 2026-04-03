package performance.upskilling.atf.ui.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;
import performance.upskilling.atf.configuration.enums.Context;
import performance.upskilling.atf.configuration.scenario_context.ScenarioContext;
import performance.upskilling.atf.util.CoreInteractions;

public class OpenAccountPageElements {

    private WebDriver driver;
    private WebDriverWait wait;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    public final Logger logger = LogManager.getLogger();
    private final CoreInteractions coreInteractions = new CoreInteractions();

    @FindBy(id = "type")
    private WebElement accountType;

    @FindBy(id = "fromAccountId")
    private WebElement fromAccountId;

    @FindBy(tagName = "input")
    private WebElement openAccountButton;

    @FindBy(id = "newAccountId")
    private WebElement newAccountId;

    @FindBy(xpath = "//div[@id='openAccountResult']//p[1]")
    private WebElement congratulationMessage;

    @FindBy(xpath = "//a[@href='logout.htm']")
    private WebElement logOutButton;

    public OpenAccountPageElements() {
        this.driver = WebDriverManager.getDriver();
        this.wait = WebDriverWaiter.getWaiter(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getAccountType() {
        return accountType;
    }

    public WebElement getFromAccountId() {
        return fromAccountId;
    }

    public WebElement getOpenAccountButton() {
        return openAccountButton;
    }

    public WebElement getCongratulationMessage() {
        return congratulationMessage;
    }

    public WebElement getNewAccountId() {
        return newAccountId;
    }

    public WebElement getLogOutButton() {
        return logOutButton;
    }

    public void selectAccountType() {
        coreInteractions.selectRandomFromDropDown(getAccountType());
        logger.debug("Selected account type: {}", getAccountType().getText());
    }

    public void selectFromAccountId() {
        coreInteractions.selectRandomFromDropDown(getFromAccountId());
        logger.debug("Selected account id: {}", getFromAccountId().getText());

        scenarioContext.setContext(Context.ACCOUNT_ID, getFromAccountId().getText());
        logger.debug("Set to Context basic account id: {}", getFromAccountId().getText());
    }

    public void clickOpenAccountButton() {
        coreInteractions.clickButton(getOpenAccountButton());
        logger.info("Clicked open account button");

        wait.until(ExpectedConditions.visibilityOf(newAccountId));
        scenarioContext.setContext(Context.NEW_ACCOUNT_ID, getNewAccountId().getText());
        logger.debug("Set to Context new account id: {}", getNewAccountId().getText());
    }

}
