package performance.upskilling.atf.ui.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pageobjects.OpenAccountPageElements;
import performance.upskilling.atf.util.CoreInteractions;

public class OpenAccountPageSteps {
    public static CoreInteractions coreInteractions = new CoreInteractions();
    public static OpenAccountPageElements openAccountPageElements = new OpenAccountPageElements();

    @And("user is on open new account page")
    public void userIsOnOpenNewAccountPage() {
        coreInteractions.navigateTo(PropertiesManager.getOpenAccountURL());
    }

    @When("user selects account type and existing account")
    public void userSelectsAccountTypeAndExistingAccount() {
        openAccountPageElements.selectAccountType();
        openAccountPageElements.selectFromAccountId();
    }

    @And("user clicks on open new account button")
    public void userClicksOnOpenNewAccountButton() {
        openAccountPageElements.clickOpenAccountButton();
    }

    @Then("new account is created")
    public void newAccountIsCreated() {
        String actualText = coreInteractions.getTextFromPage(openAccountPageElements.getCongratulationMessage());
        coreInteractions.assertPageText("Congratulations, your account is now open.",actualText);
    }

}
