package performance.upskilling.atf.ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;
import performance.upskilling.atf.ui.pageobjects.LoanPageElements;
import performance.upskilling.atf.util.TestUtils;

import java.util.Map;


public class RequestLoanImpl {
    private final LoanPageElements loanPageElements = new LoanPageElements();
    public static final Logger logger = LogManager.getLogger();
    private static final TestUtils testUtils = new TestUtils();
    public WebDriver driver;
    public static WebDriverWait wait;

    public RequestLoanImpl(WebDriver driver) {
        this.driver = driver;
        wait = WebDriverWaiter.getWaiter(driver);
    }


    public void insertLoanDetails(Map<String, String> loanData) {
        logger.info("User enters loan details");
//TODO to put logger after the actions in the methods
//TODO change the name of the method to populateField ... something like that
        testUtils.sendKeysToWebElement(loanPageElements.getLoanAmountField(), loanData.get("Loan Amount"));
        testUtils.sendKeysToWebElement(loanPageElements.getDownPaymentField(), loanData.get("Down Payment"));

        logger.info("User entered loan details");
    }

    public void clickApplyNowButton() {
        loanPageElements.getApplyLoanButton().click();
        logger.info("Clicks apply now button");
    }

    public void validateLoanRequest() {
        logger.info("Validate loan request");
        String actualText = loanPageElements.getValidationLoanText().getText();
        testUtils.assertPageText("Congratulations, your loan has been approved.", actualText);
    }

    public void printNewAccountId() {
        logger.info("Print new account id");
        String newAccountId = loanPageElements.getNewAccountId().getText();
        logger.debug("New account number is {}", newAccountId);
    }

}
