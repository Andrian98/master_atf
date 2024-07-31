package performance.upskilling.atf.ui.pagesimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;
import performance.upskilling.atf.ui.pageobjects.LoanPageElements;
import performance.upskilling.atf.util.TestCustomActions;

import java.util.Map;


public class RequestLoanImpl {
    private final LoanPageElements loanPageElements = new LoanPageElements();
    public static final Logger logger = LogManager.getLogger();
    private static final TestCustomActions testCustomActions = new TestCustomActions();
    public WebDriver driver;
    public static WebDriverWait wait;

    public RequestLoanImpl() {
        this.driver = WebDriverManager.getDriver();
        wait = WebDriverWaiter.getWaiter(driver);
    }


    public void insertLoanDetails(Map<String, String> loanData) {
//TODO to put logger after the actions in the methods
//TODO change the name of the method to populateField ... something like that
        testCustomActions.sendKeysToWebElement(loanPageElements.getLoanAmountField(), loanData.get("Loan Amount"));
        testCustomActions.sendKeysToWebElement(loanPageElements.getDownPaymentField(), loanData.get("Down Payment"));

        logger.info("User entered loan details");
    }

    public void clickApplyNowButton() {
        loanPageElements.getApplyLoanButton().click();
        logger.info("Clicks apply now button");
    }

    public void validateLoanRequest() {
        String actualText = testCustomActions.getTextFromPage(loanPageElements.getLoanText());
        testCustomActions.assertPageText("Congratulations, your loan has been approved.", actualText);
        logger.info("Validated loan request");
    }

    public void printNewAccountId() {
        String newAccountId = loanPageElements.getNewAccountId().getText();
        logger.debug("New account number is {}", newAccountId);
    }

}
