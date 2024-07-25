package performance.upskilling.atf.ui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;

public class AdminPageElements {
    private WebDriver driver;
    private WebDriverWait wait;

    // Database initialize element "database" was here initially
    @FindBy(xpath = "//button[@name='action']")
    private WebElement databaseInitialize;

    @FindBy(xpath = "(//button[@name='action'])[2]")
    private WebElement cleanDataBase;

    // JMS service status
    @FindBy(xpath = "//b[contains(text(),'JMS service status')]/following-sibling::span[contains(text(),'Running')]")
    private WebElement jmsServiceStatus;

    @FindBy(xpath = "//input[@value='jdbc']")
    private WebElement dataAccessModeJDBC;

    @FindBy(id = "soapEndpoint")
    private WebElement soapEndpoint;

    @FindBy(id = "restEndpoint")
    private WebElement restEndpoint;

    @FindBy(id = "endpoint")
    private WebElement endpoint;

    @FindBy(name = "initialBalance")
    private WebElement initBalance;

    @FindBy(name = "minimumBalance")
    private WebElement minBalance;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    public AdminPageElements() {
        this.driver = WebDriverManager.getDriver();
        this.wait = WebDriverWaiter.getWaiter(driver);
        PageFactory.initElements(driver, this);


    }

    public WebElement getDatabaseInitialize() {
        return databaseInitialize;
    }

    public WebElement getCleanDataBase() {
        return cleanDataBase;
    }

    public WebElement getJmsServiceStatus() {
        return jmsServiceStatus;
    }

    public WebElement getDataAccessModeJDBC() {
        return dataAccessModeJDBC;
    }

    public WebElement getSoapEndpoint() {
        return soapEndpoint;
    }

    public WebElement getRestEndpoint() {
        return restEndpoint;
    }

    public WebElement getEndpoint() {
        return endpoint;
    }

    public WebElement getInitBalance() {
        return initBalance;
    }

    public WebElement getMinBalance() {
        return minBalance;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }
}
