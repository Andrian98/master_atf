package performance.upskilling.atf.ui.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pages.RequestLoanImpl;
import performance.upskilling.atf.util.TestCustomActions;

import java.util.Map;

public class RequestLoanSteps {
    public static TestCustomActions testCustomActions = new TestCustomActions();
    public static String requestLoanURL = PropertiesManager.getRequestLoanURL();
    public static RequestLoanImpl requestLoanImpl = new RequestLoanImpl(WebDriverManager.getDriver());


    @Given("user is on request loan page")
    public void userIsOnRequestLoanPage() {
        testCustomActions.navigateTo(requestLoanURL);
    }


    @When("user applies for a loan with the following details")
    public void userAppliesForALoanWithTheFollowingDetails(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap();
        requestLoanImpl.insertLoanDetails(data);
        requestLoanImpl.clickApplyNowButton();
    }

    @Then("new account number is provided")
    public void newAccountNumberIsProvided() {
        requestLoanImpl.validateLoanRequest();
        requestLoanImpl.printNewAccountId();
    }

}
