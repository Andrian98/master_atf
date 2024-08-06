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
import performance.upskilling.atf.util.TestCustomActions;

import java.util.Map;

public class LoanPageElements {
    private WebDriver driver;
    private WebDriverWait wait;
    public static final Logger logger = LogManager.getLogger();
    private static final TestCustomActions testCustomActions = new TestCustomActions();

    @FindBy(id = "amount")
    private WebElement loanAmountField;

    @FindBy(id = "downPayment")
    private WebElement downPaymentField;

    //Locate the "From Account" dropdown
    @FindBy(id = "fromAccountId")
    private WebElement fromAccountDropdown;

    @FindBy(xpath = "//input[@value='Apply Now']")
    private WebElement applyLoanButton;

    @FindBy(xpath = "//p[text()='Congratulations, your loan has been approved.']")
    private WebElement loanText;

    @FindBy(id = "newAccountId")
    private WebElement newAccountId;

    public LoanPageElements() {
        this.driver = WebDriverManager.getDriver();
        this.wait = WebDriverWaiter.getWaiter(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getApplyLoanButton() {
        return applyLoanButton;
    }

    public WebElement getFromAccountDropdown() {
        return fromAccountDropdown;
    }

    public WebElement getDownPaymentField() {
        return downPaymentField;
    }

    public WebElement getLoanAmountField() {
        return loanAmountField;
    }

    public WebElement getLoanText() {
        return loanText;
    }

    public WebElement getNewAccountId() {
        return newAccountId;
    }

    public void populateLoanFields(Map<String, String> loanData) {
        testCustomActions.sendKeysToWebElement(getLoanAmountField(), loanData.get("Loan Amount"));
        testCustomActions.sendKeysToWebElement(getDownPaymentField(), loanData.get("Down Payment"));
        logger.info("User entered loan details");
    }

    public void clickApplyNowButton() {
        testCustomActions.clickButton(getApplyLoanButton());
        logger.info("Clicks apply now button");
    }

    public void validateLoanRequest() {
        String actualText = testCustomActions.getTextFromPage(getLoanText());
        testCustomActions.assertPageText("Congratulations, your loan has been approved.", actualText);
        logger.info("Validated loan request");
    }

    public void printNewAccountId() {
        String newAccountId = getNewAccountId().getText();
        logger.debug("New account number is {}", newAccountId);
    }
}
