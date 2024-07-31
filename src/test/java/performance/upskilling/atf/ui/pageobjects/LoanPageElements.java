package performance.upskilling.atf.ui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;

public class LoanPageElements {
    private WebDriver driver;
    private WebDriverWait wait;

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
}
