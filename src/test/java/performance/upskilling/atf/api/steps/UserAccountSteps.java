package performance.upskilling.atf.api.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.api.actions.UserActions;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserAccountSteps {
    private static final Logger logger = LogManager.getLogger();
    private final UserActions userActions = new UserActions();
    private int validCustomerId;
    private static final String username = PropertiesManager.getUsername();
    private static final String password = PropertiesManager.getPassword();
    public Response response;


    @Given("data for account creation")
    public void dataForAccountCreation() {
        validCustomerId = userActions.getLoginResponse(username, password).getId();
        userActions.getCustomerAccounts(validCustomerId);
        logger.info("Successfully created data for new account.");
    }

    @When("user sends a POST request to create account")
    public void userSendsAPOSTRequestToCreateAccount() {
        response = userActions.createNewAccount(validCustomerId);
        logger.info("Successfully send POST request for new account.");
    }

    @Then("request returns a success status code")
    public void requestReturnsASuccessStatusCode() {
        assertThat(response.getStatusCode(), equalTo(200));
        logger.info("Successfully validated response of the new account creation.");
    }

    @When("user sends a POST request to create Account with customerId {string}")
    public void userSendsAPOSTRequestToCreateAccountWithCustomerId(String invalidCustomerId) {
        response = userActions.createNewAccount(Integer.parseInt(invalidCustomerId));
        logger.info("Successfully send POST request for new account with invalid customer id.");
    }

    @Then("account creation failed with error {string}")
    public void accountCreationFailedWithError(String expectedErrorMessage) {
        assertThat(response.getStatusCode(), equalTo(400));
        assertThat(response.getBody().asString(), equalTo(expectedErrorMessage + userActions.getFromAccountId()));
        logger.info("Successfully validated error message of the invalid account creation.");
    }

}
