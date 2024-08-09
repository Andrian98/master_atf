package performance.upskilling.atf.ui.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import performance.upskilling.atf.configuration.enums.Context;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pageobjects.OpenAccountPageElements;
import performance.upskilling.atf.util.TestCustomActions;

public class OpenAccountPageSteps {
    public static TestCustomActions testCustomActions = new TestCustomActions();
    public static OpenAccountPageElements openAccountPageElements = new OpenAccountPageElements();

    @And("user is on open new account page")
    public void userIsOnOpenNewAccountPage() {
        testCustomActions.navigateTo(PropertiesManager.getOpenAccountURL());
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
        String actualText = testCustomActions.getTextFromPage(openAccountPageElements.getCongratulationMessage());
        testCustomActions.assertPageText("Congratulations, your account is now open.",actualText);
    }


}
