package performance.upskilling.atf.ui.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pagesimpl.LoginPageImpl;
import performance.upskilling.atf.util.TestCustomActions;

public class LoginPageSteps {
    public static TestCustomActions testCustomActions = new TestCustomActions();
    public static String loginURL = PropertiesManager.getIndexURL();
    public static LoginPageImpl loginPageImp = new LoginPageImpl();


    @Given("user is on main page")
    public void userIsOnMainPage() {
        testCustomActions.navigateTo(loginURL);
    }

    @When("user enters valid credentials")
    public void userEntersValidCredentials() {
        loginPageImp.userLogin();
        loginPageImp.userClickSubmit();
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {
        loginPageImp.validateWelcomeMessage();
    }

}
