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
import performance.upskilling.atf.configuration.enums.Context;
import performance.upskilling.atf.configuration.scenario_context.ScenarioContext;
import performance.upskilling.atf.util.TestCustomActions;

public class OpenAccountPageElements {

    private WebDriver driver;
    private WebDriverWait wait;
    private ScenarioContext scenarioContext;
    public static final Logger logger = LogManager.getLogger();
    private static final TestCustomActions testCustomActions = new TestCustomActions();

    @FindBy(id = "type")
    private WebElement accountType;

    @FindBy(id = "fromAccountId")
    private WebElement fromAccountId;

    @FindBy(tagName = "input")
    private WebElement openAccountButton;

    @FindBy(id = "newAccountId")
    private WebElement newAccountId;

    @FindBy(xpath = "//p[text()='Congratulations, your account is now open.']")
    private WebElement congratulations;

    public OpenAccountPageElements() {
        this.driver = WebDriverManager.getDriver();
        this.wait = WebDriverWaiter.getWaiter(driver);
        PageFactory.initElements(driver, this);
        scenarioContext = new ScenarioContext();
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
        return congratulations;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

    public WebElement getNewAccountId() {
        return newAccountId;
    }

    public void selectAccountType() {
        testCustomActions.selectFromDropDown(getAccountType());
        logger.debug("Selected account type: {}", getAccountType().getText());
    }

    public void selectFromAccountId() {
        testCustomActions.selectFromDropDown(getFromAccountId());
        logger.debug("Selected account id: {}", getFromAccountId().getText());
    }

    public void clickOpenAccountButton() {
        testCustomActions.clickButton(getOpenAccountButton());
        logger.info("Clicked open account button");
    }

    public void addNewIdToContext(){
        scenarioContext.setContext(Context.NEW_ACCOUNT_ID,getNewAccountId().getText());
        logger.debug("New account id: {}", getNewAccountId().getText());
    }

    public void validateNewAccountID() {

    }

}
