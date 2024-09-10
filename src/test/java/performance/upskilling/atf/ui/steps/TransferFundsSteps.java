package performance.upskilling.atf.ui.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pageobjects.TransferPageElements;
import performance.upskilling.atf.util.TestCustomActions;

public class TransferFundsSteps {

    private static final TestCustomActions testCustomActions = new TestCustomActions();
    private static final TransferPageElements transferPageElements = new TransferPageElements();

    @And("user is on transfer funds page")
    public void userIsOnTransferFundsPage() {
        testCustomActions.navigateTo(PropertiesManager.getTransferUrl());
    }

    @And("user selected From account and To account")
    public void userSelectedFromAccountAndToAccount() {
        testCustomActions.selectRandomFromDropDown(transferPageElements.getFromAccountId());
        testCustomActions.selectRandomFromDropDown(transferPageElements.getToAccountId());
    }

    @When("user enters valid amount to transfer")
    public void userEntersValidAmountToTransfer() {
        testCustomActions.sendKeysToWebElement(transferPageElements.getAmount(),"50000");
        testCustomActions.clickButton(transferPageElements.getSubmit());
    }

    @Then("transfer successfully completed")
    public void transferSuccessfullyCompleted() {
        testCustomActions.assertPageText("Transfer Complete!",transferPageElements.getTransferSuccessMessage().getText());
        testCustomActions.clickButton(transferPageElements.getLogOutButton());
    }
}
