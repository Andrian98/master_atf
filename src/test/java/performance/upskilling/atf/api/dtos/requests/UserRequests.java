package performance.upskilling.atf.api.dtos.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.configuration.properties.PropertiesManager;


public class UserRequests {
    public static final Logger logger = LogManager.getLogger(UserRequests.class);
    private RequestSpecification request;
    private Response response;

    public UserRequests() {
        request = RestAssured.given().header("Content-Type", "application/json");
    }

    public Response getRequest(String url) {
        request = RestAssured.given();
        response = request.get(url);
        if (response.getStatusCode() >= 400) {
            logger.error("Could not access the url {} ", url + response.getStatusCode());
        } else {
            logger.info("Successfully accessed page {}", url);
        }
        return response;
    }

}
