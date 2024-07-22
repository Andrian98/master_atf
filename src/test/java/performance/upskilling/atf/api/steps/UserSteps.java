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
    //TODO Do not reuse customerID (to be removed)
    //TODO can not be reused from the first test
    //TODO Use the method login from the first scenario to take the customerId in the second

    @Given("data for new account are created")
    public void dataForNewAccountAreCreated() {
        //TODO methods to be more specific in the name (actions)
        userActions.userAccounts(customerId);
        userActions.printUserAccounts();
        logger.info("Successfully created data for new account.");
    }

    @When("user sends a POST request to create the new account")
    public void userSendsAPOSTRequestToCreateTheNewAccount() {
        userResponse = userActions.createNewAccount(customerId);
        logger.info("Successfully send POST request for new account.");
    }

    //TODO what is the parameter of the success
    //TODO Null assert are not required
    @Then("new account was successfully created")
    public void newAccountWasSuccessfullyCreated() {
        Assert.assertNotNull(userResponse);
        Assert.assertEquals(customerId, userResponse.getCustomerId());
        logger.info("Successfully validated response of the new account creation.");
    }

    @When("user sends a POST request to createAccount with customerId {string}")
    public void userSendsAPOSTRequestToCreateAccountWithCustomerId(String invalidCustomerId) {
        userResponse = userActions.createNewAccount(Integer.parseInt(invalidCustomerId));
        logger.info("Successfully send POST request for new account with invalid customer id.");
    }

    @Then("account creation failed with the expected error message {string}")
    public void accountCreationFailedWithTheExpectedErrorMessage(String expectedErrorMessage) {
        Assert.assertNotNull(userResponse);
        System.out.println("Error message: " + userResponse);
        //TODO Validate
        //TODO add the validation by status code
        //TODO review the step naming
        //TODO pay attention when you put string and int and what message is expected
        Assert.fail(expectedErrorMessage + userActions.getFromAccountId());
    }

}
