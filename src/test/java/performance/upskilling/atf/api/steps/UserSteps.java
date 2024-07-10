package performance.upskilling.atf.api.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.api.actions.UserActions;
import performance.upskilling.atf.api.dtos.response.LoginResponse;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.util.TestUtils;

import java.util.Map;

public class UserSteps {
    private static final Logger logger = LogManager.getLogger();
    private static final UserActions userActions = new UserActions();
    private static LoginResponse loginResponse;
    private static final TestUtils testUtils = new TestUtils();
    private static Response response;


    @Given("server is up")
    public void serverIsUp() {
        userActions.getRequest(PropertiesManager.getIndexURL());
    }

    @When("user logs in with the following credentials")
    public void userLogsInWithTheFollowingCredentials(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);
        response = userActions.userLogin(data.get("username"), data.get("password"));
        logger.info("Successfully logged in with Username: {}", data.get("username"));
    }

    @Then("user successfully logged in")
    public void userSuccessfullyLoggedIn() {
        //TODO in case like this there are no need for a method assert here(review)
        loginResponse = new LoginResponse(response.getBody().asString());
        testUtils.assertPageText("ParaBank | Accounts Overview", loginResponse.getTitle());
        logger.info("Successfully logged in");
    }

}
