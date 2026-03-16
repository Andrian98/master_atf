package performance.upskilling.atf.api.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.api.actions.UserActions;
import performance.upskilling.atf.api.dtos.response.LoginResponse;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserLoginSteps {
    private final UserActions userActions = new UserActions();
    private final Logger logger = LogManager.getLogger();
    private LoginResponse loginResponse;
    private Response response;

    @Given("server is ready to accept API request")
    public void serverIsReadyToAcceptAPIRequest() {
        userActions.serverValidation(PropertiesManager.getIndexURL());
        logger.info("server is ready to accept API request");
    }

    @When("user logs in with the username {string} and password {string}")
    public void userLogsInWithTheFollowingCredentials(String username, String password) {
        loginResponse = userActions.getLoginResponse(username, password);
        logger.info("Successfully logged in with Username: {}", username);
    }

    @Then("user successfully logged in")
    public void userSuccessfullyLoggedIn() {
        assertThat("perf", equalTo(loginResponse.getFirstName()));
        assertThat("user", equalTo(loginResponse.getLastName()));
        logger.info("Successfully validated login of the user.");
    }

    @When("user logs in with the {string} and {string}")
    public void userLogsInWithTheAnd(String username, String password) {
       response = userActions.sentUserLoginRequest(username, password);
        logger.info("User sent login request with Username: {}", username);
    }

    @Then("error message is displayed {string}")
    public void errorMessageIsDisplayed(String errorMessage) {
        assertThat(response.getStatusCode(), equalTo(400));
        assertThat(errorMessage, equalTo(response.getBody().asString()));
        logger.info("Successfully validated error message of the invalid username/password");
    }
}
