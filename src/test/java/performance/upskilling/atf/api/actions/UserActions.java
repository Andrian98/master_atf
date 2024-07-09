package performance.upskilling.atf.api.actions;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

import static org.apache.http.HttpStatus.SC_MOVED_TEMPORARILY;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserActions {
    private static final Logger logger = LogManager.getLogger();
    public static RequestSpecification request;
    public static Response response;

    public void accessPage(String url) {
        try {
            request = RestAssured.given();
            response = request.get(url);
        } catch (Exception e) {
            logger.error("Could not access the url {} ", url + response.getStatusCode(), e);
        }
        logger.info("Successfully accessed page {}", url);
    }

    public Response userLogin(String username, String password) {
        logger.debug("Login with Username {}", username);
        request = RestAssured.given()
                .queryParam("username", username)
                .queryParam("password", password);
        response = request.post(PropertiesManager.getLoginURL());
        logger.info("BODY that was submit {}", response.getBody().toString());
        // Check if the response is a redirect
        if (response.statusCode() == 302) {
            String redirectUrl = response.getHeader("Location");
            logger.debug("Redirect URL: {}", redirectUrl);

            response = RestAssured.given().get(redirectUrl);
        }
        return response;
    }
}
