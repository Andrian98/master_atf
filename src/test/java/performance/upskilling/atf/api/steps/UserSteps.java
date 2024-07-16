package performance.upskilling.atf.api.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
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
    private static LoginResponse loginResponse;
    private UserResponse userResponse = new UserResponse();
    private UserRequests userRequests = new UserRequests();


    @Given("server is ready to accept API request")
    public void serverIsReadyToAcceptAPIRequest() {
        userActions.serverValidation(PropertiesManager.getIndexURL());
    }

    @When("user logs in with the following credentials")
    public void userLogsInWithTheFollowingCredentials(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap();
        userActions.userLogin(data.get("username"), data.get("password"));
        logger.info("Successfully logged in with Username: {}", data.get("username"));
    }

    @Then("user successfully logged in")
    public void userSuccessfullyLoggedIn() {
        loginResponse = userActions.getLoginResponse();

        Assert.assertNotNull(loginResponse);
        Assert.assertEquals("perf", loginResponse.getFirstName());
        Assert.assertEquals("user", loginResponse.getLastName());
        logger.info("Successfully logged in");
    }

}
