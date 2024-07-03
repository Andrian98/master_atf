package performance.upskilling.atf.api.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import performance.upskilling.atf.api.actions.UserActions;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

import java.util.List;
import java.util.Map;

public class UserSteps {
    private static final UserActions userActions = new UserActions();

    //TODO Implement the assertions in the steps

    @Given("user can access home page")
    public void userCanAccessHomePage() {
        userActions.accessPage(PropertiesManager.getURL());
    }

    @When("user logs in with the following credentials")
    public void userLogsInWithTheFollowingCredentials(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String username = data.get(0).get("username");
        String password = data.get(0).get("password");

        userActions.userLogin(username, password);
    }

    @Then("register total balance")
    public void registerTotalBalance() {
        //TODO implement the step
    }

}
