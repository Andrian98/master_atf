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

public class TransferPageElements {
    private WebDriver driver;
    private WebDriverWait wait;
    public static final Logger logger = LogManager.getLogger();

    @FindBy(id = "amount")
    private WebElement amount;

    @FindBy(id = "fromAccountId")
    private WebElement fromAccountId;

    @FindBy(id = "toAccountId")
    private WebElement toAccountId;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = "//h1[text()='Transfer Complete!']")
    private WebElement transferSuccessMessage;

    public TransferPageElements(){
        this.driver = WebDriverManager.getDriver();
        this.wait = WebDriverWaiter.getWaiter(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getAmount() {
        return amount;
    }

    public WebElement getFromAccountId() {
        return fromAccountId;
    }

    public WebElement getToAccountId() {
        return toAccountId;
    }

    public WebElement getSubmit() {
        return submit;
    }

    public WebElement getTransferSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(transferSuccessMessage));
        return transferSuccessMessage;
    }

}
