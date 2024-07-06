package performance.upskilling.atf.api.actions;


import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

import static org.apache.http.HttpStatus.SC_MOVED_TEMPORARILY;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserActions {
    private static final Logger logger = LogManager.getLogger();
    //TODO assertion should not be in the GIVEN or in the method that is used in GIVEN, you can catch an exception
    //TODO separate the Request and the Response in method.
    public void accessPage(String url) {
        logger.debug("Accessing page {}", url);
         RestAssured.given()
                .get(url)
                .then()
                .assertThat().statusCode(SC_OK);
        logger.info("Successfully accessed page {}", url);
    }

    public void userLogin(String username, String password) {
        logger.debug("Login with Username {}", username);
        RestAssured.given()
                .queryParam("username", username)
                .queryParam("password", password)
                .post(PropertiesManager.getLoginURL())
                .then()
                .assertThat().statusCode(SC_MOVED_TEMPORARILY);
        logger.info("Successfully logged in with Username {} ", username);
    }
}
