package performance.upskilling.atf.ui.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pageobjects.LoginPageElements;
import performance.upskilling.atf.util.TestCustomActions;

public class LoginPageSteps {
    public static TestCustomActions testCustomActions = new TestCustomActions();
    public static LoginPageElements loginPageElements = new LoginPageElements();

    @Given("user is on main page")
    public void userIsOnMainPage() {
        testCustomActions.navigateTo(PropertiesManager.getIndexURL());
    }

    @When("user enters valid credentials")
    public void userEntersValidCredentials() {
        loginPageElements.userLogin();
        loginPageElements.userClickSubmit();
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {
        loginPageElements.validateWelcomeMessage();
    }

}
