package performance.upskilling.atf.api.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import performance.upskilling.atf.api.actions.UserActions;
import performance.upskilling.atf.api.dtos.response.UserResponse;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.util.TestUtils;

import java.util.List;
import java.util.Map;

public class UserSteps {
    private static final UserActions userActions = new UserActions();
    private static final UserResponse userResponse = new UserResponse();
    private static final TestUtils testUtils = new TestUtils();

    //TODO do not do assertion in the GIVEN
    @Given("user navigates to home page")
    public void userNavigatesToHomePage() {
        userActions.accessPage(PropertiesManager.getURL());
        String actualTitle = testUtils.extractPageTitle(PropertiesManager.getURL());
        testUtils.assertPageText("ParaBank | Welcome | Online Banking", actualTitle);
    }

    @When("user logs in with the following credentials")
    public void userLogsInWithTheFollowingCredentials(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String username = data.get(0).get("username");
        String password = data.get(0).get("password");

        userActions.userLogin(username, password);
        String actualText = testUtils.extractPageTitle(PropertiesManager.getOverviewURL());
        testUtils.assertPageText("ParaBank | Error", actualText);
    }

    @Then("user successfully logged in")
    public void userSuccessfullyLoggedIn() {
        //TODO implement the step
        //TODO Assertion should be here at THEN
    }

}
