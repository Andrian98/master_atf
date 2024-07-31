package performance.upskilling.atf.ui.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.util.TestCustomActions;

public class TransferFundsSteps {

    private static final TestCustomActions testCustomActions = new TestCustomActions();

    @Given("user is on transfer funds page")
    public void userIsOnTransferFundsPage() {
        testCustomActions.navigateTo(PropertiesManager.getTransferUrl());
    }

    @When("user selected From account and To account")
    public void userSelectedFromAccountAndToAccount() {

    }

    @When("user enters invalid amount to transfer")
    public void userEntersInvalidAmountToTransfer() {

    }

    @Then("transfer fails with an error message corresponding to the invalid amount")
    public void transferFailsWithAnErrorMessageCorrespondingToTheInvalidAmount() {

    }
}
