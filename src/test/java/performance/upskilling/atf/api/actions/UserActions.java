package performance.upskilling.atf.api.actions;


import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.api.dtos.requests.UserRequests;
import performance.upskilling.atf.api.dtos.response.LoginResponse;
import performance.upskilling.atf.api.dtos.response.UserResponse;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserActions {
    private static final Logger logger = LogManager.getLogger();
    public static Response response;
    public static UserRequests userRequests = new UserRequests();
    public static List<UserResponse> userResponses;
    public static int fromAccountId;

    public UserActions() {
        RestAssured.defaultParser = Parser.JSON;
    }

    public void serverValidation(String url) {
        userRequests.getRequest(url);
    }

    public void userLogin(String username, String password) {
        logger.debug("Login with Username {}", username);
        String loginURL = String.format("%s/%s/%s", PropertiesManager.getLoginURL(), username, password);

        response = userRequests.getRequest(loginURL);
        logger.debug("Response that was received {}", response.getBody().asString());
    }

    public LoginResponse getLoginResponse() {
        logger.info("Get login response");
        return response.then().extract().body().as(LoginResponse.class);
    }

    public void userAccounts(Integer customerId) {
        logger.info("Getting user account details");
        String userAccountsURL = String.format("%s%s/accounts", PropertiesManager.getUserAccountsURL(), customerId);

        response = userRequests.getRequest(userAccountsURL);
    }

    public List<UserResponse> getCustomerAccounts() {
        logger.info("Get customer account details");
        userResponses = response.jsonPath().getList("", UserResponse.class);
        return userResponses;
    }

    //TODO list a called twice here
    public void printUserAccounts() {
        List<UserResponse> userResponses = getCustomerAccounts();
//TODO one validation can be removed empty
        if (userResponses != null && !userResponses.isEmpty()) {
            for (UserResponse userResponse : userResponses) {
                logger.debug("Response: {}", userResponse);
            }
        } else {
            logger.error("No accounts found for customer.");
        }
    }

    public String buildQueryParams(int customerId) {
        logger.info("Building query parameters");
        int newAccountType = 0;
        fromAccountId = userResponses.get(0).getId();

        return String.format("customerId=%d&newAccountType=%d&fromAccountId=%d", customerId, newAccountType, fromAccountId);
    }

    public UserResponse createNewAccount(int customerId) {
        logger.info("Creating new account.");

        response = userRequests.postRequest(PropertiesManager.getCreateAccountURL(), buildQueryParams(customerId));
        logger.debug("Response that was received: {}", response.getBody().asString());
        return response.then().extract().body().as(UserResponse.class);
    }

    public int getFromAccountId() {
        return fromAccountId;
    }

}
