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

public class UserActions {
    private final Logger logger = LogManager.getLogger();
    private Response response;
    private UserRequests userRequests = new UserRequests();
    private List<UserResponse> userResponses;
    private int fromAccountId;

    public UserActions() {
        RestAssured.defaultParser = Parser.JSON;
    }

    public void serverValidation(String url) {
        userRequests.getRequest(url);
    }

    public Response sentUserLoginRequest(String username, String password) {
        logger.debug("Login with Username {}", username);
        String loginURL = String.format("%s/%s/%s", PropertiesManager.getLoginURL(), username, password);
        response = userRequests.getRequest(loginURL);
        logger.debug("Response that was received {}", response.getBody().asString());
        return response;
    }

    public LoginResponse getLoginResponse(String username, String password) {
        sentUserLoginRequest(username, password);
        logger.info("Get login response");
        return response.then().extract().body().as(LoginResponse.class);
    }

    public void getCustomerAccounts(Integer validCustomerId) {
        logger.info("Get customer account details");
        String userAccountsURL = String.format("%s%s/accounts", PropertiesManager.getUserAccountsURL(), validCustomerId);

        response = userRequests.getRequest(userAccountsURL);
        userResponses = response.jsonPath().getList("", UserResponse.class);
    }

    public String buildQueryParams(int customCustomerId) {
        logger.info("Building query parameters");
        int newAccountType = 0;
        fromAccountId = userResponses.get(0).getId();

        return String.format("customerId=%d&newAccountType=%d&fromAccountId=%d", customCustomerId, newAccountType, fromAccountId);
    }

    public Response createNewAccount(int customCustomerId) {
        response = userRequests.postRequest(PropertiesManager.getCreateAccountURL(), buildQueryParams(customCustomerId));
        logger.debug("Response that was received: {}", response.getBody().asString());
        return response;
    }

    public int getFromAccountId() {
        return fromAccountId;
    }

}
