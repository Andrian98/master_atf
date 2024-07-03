package performance.upskilling.atf.api.actions;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

import static org.apache.http.HttpStatus.SC_MOVED_TEMPORARILY;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserActions {
    private static RequestSpecification request;
    private static Response response;

    public void accessPage(String url) {
        RestAssured.given()
                .get(url)
                .then()
                .assertThat().statusCode(SC_OK);
    }

    public void userLogin(String username, String password) {
        RestAssured.given()
                .queryParam("username", username)
                .queryParam("password", password)
                .post(PropertiesManager.getLoginURL())
                .then()
                .assertThat().statusCode(SC_MOVED_TEMPORARILY);
    }
}
