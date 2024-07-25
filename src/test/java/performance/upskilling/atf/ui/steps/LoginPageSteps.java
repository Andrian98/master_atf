package performance.upskilling.atf.ui.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pages.LoginPageImpl;
import performance.upskilling.atf.util.TestCustomActions;

public class LoginPageSteps {
    public static TestCustomActions testCustomActions = new TestCustomActions();
    public static String loginURL = PropertiesManager.getIndexURL();
    public static LoginPageImpl loginPageImp = new LoginPageImpl(WebDriverManager.getDriver());


    @Given("user is on main page")
    public void userIsOnMainPage() {
        testCustomActions.navigateTo(loginURL);
    }

    @When("user enters his credentials")
    public void userEntersHisCredentials() {
        loginPageImp.userLogin();
        loginPageImp.userClickSubmit();
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {
        loginPageImp.validateWelcomeMessage();
    }

}
