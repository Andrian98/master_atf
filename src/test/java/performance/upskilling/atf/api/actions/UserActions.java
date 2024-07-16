package performance.upskilling.atf.api.actions;


import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.api.dtos.requests.UserRequests;
import performance.upskilling.atf.api.dtos.response.LoginResponse;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserActions {
    private static final Logger logger = LogManager.getLogger();
    public static Response response;
    public static UserRequests userRequests = new UserRequests();

    public void serverValidation(String url) {
        userRequests.getRequest(url);
    }

    public UserActions() {
        RestAssured.defaultParser = Parser.JSON;
    }

    public void userLogin(String username, String password) {
        logger.debug("Login with Username {}", username);
        String loginURL = String.format("%s/%s/%s",PropertiesManager.getLoginURL(),username,password);
        response = RestAssured.given()
                .header("accept", "application/json")
                .get(loginURL);

        logger.debug("Response that was received {}", response.getBody().asString());
    }

    public LoginResponse getLoginResponse() {
        logger.info("Get login response");
        return response
                .then()
                .extract()
                .body()
                .as(LoginResponse.class);
    }
}
