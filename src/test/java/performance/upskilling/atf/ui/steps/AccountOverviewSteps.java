package performance.upskilling.atf.ui.steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pageobjects.AccountOverviewPageElements;
import performance.upskilling.atf.util.TestCustomActions;

public class AccountOverviewSteps {
    public static TestCustomActions testCustomActions = new TestCustomActions();
    public static AccountOverviewPageElements accountOverviewPageElements = new AccountOverviewPageElements();


    @When("user navigated to account overview page")
    public void userNavigatedToAccountOverviewPage() {
        testCustomActions.navigateTo(PropertiesManager.getAccountOverview());
    }

    @Then("new accounts id are validated")
    public void newAccountsIdAreValidated() {
        accountOverviewPageElements.validationOfNewAccount();
    }

}
