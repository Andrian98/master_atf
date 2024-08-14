package performance.upskilling.atf.ui.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static performance.upskilling.atf.configuration.enums.Context.NEW_ACCOUNT_ID;

public class AccountOverviewPageElements {
    private WebDriver driver;
    private WebDriverWait wait;

    public static final Logger logger = LogManager.getLogger();
    private static final TestCustomActions testCustomActions = new TestCustomActions();

    @FindBy(xpath = "//*[@id='showOverview']")
    private WebElement accountTable;


    public AccountOverviewPageElements() {
        this.driver = WebDriverManager.getDriver();
        this.wait = WebDriverWaiter.getWaiter(driver);
        PageFactory.initElements(driver, this);
    }

    public List<String> getNewAccountIDs() {
        System.out.println("WebElement SIZE: "   + accountTable.findElements(By.tagName("a")).size());
        System.out.println("WebElement: "   + accountTable.getText());
        return accountTable.findElements(By.tagName("a")) // Find all anchor tags within the table
                .stream()
                .map(WebElement::getText) // Extract text from each anchor tag
                .collect(Collectors.toList()); // Collect all IDs into a List
    }

    public void validationOfNewAccount() {
        System.out.println("GET NEW ACCOUNT: " + getNewAccountIDs());
        String newAccountId = ScenarioContext.getInstance().getContext(Context.NEW_ACCOUNT_ID);
        if (newAccountId != null) {
            List<String> accountIds = getNewAccountIDs();
            assertThat("New account ID is present in the Account table",accountIds.contains(newAccountId));
            logger.info("Account ID is present in the Account table");
        } else {
            logger.error("No new account ID found in the context.");
        }
    }
}
