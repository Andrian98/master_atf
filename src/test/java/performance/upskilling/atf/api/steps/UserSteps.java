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

import java.util.List;
import java.util.Map;

public class UserSteps {
    private static final Logger logger = LogManager.getLogger();
    private static final UserActions userActions = new UserActions();
    private static final TestUtils testUtils = new TestUtils();
    private static LoginResponse loginResponse;
    private UserResponse userResponse;
    private static int customerId;


    @Given("server is ready to accept API request")
    public void serverIsReadyToAcceptAPIRequest() {
        userActions.serverValidation(PropertiesManager.getIndexURL());
        logger.info("server is ready to accept API request");
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
        logger.info("Successfully validated login of the user.");
        customerId = loginResponse.getId();
    }

    @Given("data for new account are created")
    public void dataForNewAccountAreCreated() {
        userActions.userAccounts(customerId);
        userActions.printUserAccounts();
        logger.info("Successfully created data for new account.");
    }

    @When("user sends a POST request to create the new account")
    public void userSendsAPOSTRequestToCreateTheNewAccount() {
        userResponse = userActions.createNewAccount();
        logger.info("Successfully send POST request for new account.");
    }

    @Then("new account was successfully created")
    public void newAccountWasSuccessfullyCreated() {
        Assert.assertNotNull(userResponse);
        Assert.assertEquals(customerId, userResponse.getId());
        logger.info("Successfully validated response of the new account creation.");
    }

    @When("user sends a POST request to createAccount with accountId {string}")
    public void userSendsAPOSTRequestToCreateAccountWithAccountId(String arg0) {

    }

    @Then("account creation failed with the expected error message")
    public void accountCreationFailedWithTheExpectedErrorMessage() {

    }

}
