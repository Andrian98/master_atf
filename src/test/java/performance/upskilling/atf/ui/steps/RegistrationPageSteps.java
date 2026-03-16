package performance.upskilling.atf.ui.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pageobjects.RegistrationPageElements;
import performance.upskilling.atf.util.TestCustomActions;

import java.util.Map;

public class RegistrationPageSteps {
    public static TestCustomActions testCustomActions = new TestCustomActions();
    public RegistrationPageElements registrationPageElements = new RegistrationPageElements();

    @Given("user is on registration page")
    public void userIsOnRegistrationPage() {
        testCustomActions.navigateTo(PropertiesManager.getRegisterURL());
    }

    @When("user populates form with the following details")
    public void userPopulatesFormWithTheFollowingDetails(DataTable dataTable) {
        Map<String, String> userDetails = dataTable.transpose().asMap();
        registrationPageElements.insertRegisterDetails(userDetails);
        testCustomActions.clickButton(registrationPageElements.getRegisterButton());
    }
//TODO try to put the logout in the hooks of the UI
    @Then("message {string} is displayed")
    public void webElementWithMessageIsDisplayed(String expectedMessage) {
        testCustomActions.assertPageText(registrationPageElements.validateUserCreation(), expectedMessage);
        testCustomActions.clickButton(registrationPageElements.getLogOutButton());
    }
}
