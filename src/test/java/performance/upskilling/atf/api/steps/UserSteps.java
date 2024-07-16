package performance.upskilling.atf.api.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.api.actions.UserActions;
import performance.upskilling.atf.api.dtos.requests.UserRequests;
import performance.upskilling.atf.api.dtos.response.LoginResponse;
import performance.upskilling.atf.api.dtos.response.UserResponse;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.util.TestUtils;

import java.util.Map;

public class UserSteps {
    private static final Logger logger = LogManager.getLogger();
    private static final UserActions userActions = new UserActions();
    private static final TestUtils testUtils = new TestUtils();
    private static Response response;
    private UserResponse userResponse = new UserResponse();
    private UserRequests userRequests = new UserRequests();


    @Given("server is up")
    public void serverIsUp() {
        userActions.serverValidation(PropertiesManager.getIndexURL());
    }

    @When("user logs in with the following credentials")
    public void userLogsInWithTheFollowingCredentials(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap();
        response = userActions.userLogin(data.get("username"), data.get("password"));
        logger.info("Successfully logged in with Username: {}", data.get("username"));
    }

    @Then("user successfully logged in")
    public void userSuccessfullyLoggedIn() {
        LoginResponse loginResponse = new LoginResponse(response.getBody().asString());
        testUtils.assertPageText("ParaBank | Accounts Overview", loginResponse.getTitle());
        logger.info("Successfully logged in");
    }

}
