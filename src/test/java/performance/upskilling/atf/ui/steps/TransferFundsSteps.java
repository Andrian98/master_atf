package performance.upskilling.atf.ui.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pageobjects.TransferPageElements;
import performance.upskilling.atf.util.CoreInteractions;

public class TransferFundsSteps {

    private static final CoreInteractions CORE_INTERACTIONS = new CoreInteractions();
    private static final TransferPageElements transferPageElements = new TransferPageElements();

    @And("user is on transfer funds page")
    public void userIsOnTransferFundsPage() {
        CORE_INTERACTIONS.navigateTo(PropertiesManager.getTransferUrl());
    }

    @And("user selected From account and To account")
    public void userSelectedFromAccountAndToAccount() {
        CORE_INTERACTIONS.selectRandomFromDropDown(transferPageElements.getFromAccountId());
        CORE_INTERACTIONS.selectRandomFromDropDown(transferPageElements.getToAccountId());
    }

    @When("user enters valid amount to transfer")
    public void userEntersValidAmountToTransfer() {
        CORE_INTERACTIONS.sendKeysToWebElement(transferPageElements.getAmount(),"50000");
        CORE_INTERACTIONS.clickButton(transferPageElements.getSubmit());
    }

    @Then("transfer successfully completed")
    public void transferSuccessfullyCompleted() {
        CORE_INTERACTIONS.assertPageText("Transfer Complete!",transferPageElements.getTransferSuccessMessage().getText());
    }
}
