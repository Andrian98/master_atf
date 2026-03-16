package performance.upskilling.atf.ui.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pageobjects.LoanPageElements;
import performance.upskilling.atf.util.TestCustomActions;

import java.util.Map;

public class RequestLoanSteps {
    private TestCustomActions testCustomActions = new TestCustomActions();
    private String requestLoanURL = PropertiesManager.getRequestLoanURL();
    private LoanPageElements loanPageElements = new LoanPageElements();


    @And("user is on request loan page")
    public void userIsOnRequestLoanPage() {
        testCustomActions.navigateTo(requestLoanURL);
    }

    @When("user applies for a loan with the following details")
    public void userAppliesForALoanWithTheFollowingDetails(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap();
        loanPageElements.populateLoanFields(data);
        loanPageElements.clickApplyNowButton();
    }

    @Then("new account number is provided")
    public void newAccountNumberIsProvided() {
        loanPageElements.validateLoanRequest();
        loanPageElements.printNewAccountId();
        testCustomActions.clickButton(loanPageElements.getLogOutButton());
    }

}
