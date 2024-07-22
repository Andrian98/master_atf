package performance.upskilling.atf.api.dtos.requests;

import io.opentelemetry.sdk.logs.data.Body;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.configuration.properties.PropertiesManager;


public class UserRequests {
    public static final Logger logger = LogManager.getLogger();
    private final RequestSpecification request;
    private Response response;

    public UserRequests() {
        request = RestAssured.given().header("Content-Type", "application/json")
                .header("Accept", "application/json");
    }

    public Response getRequest(String url) {
        response = request.get(url);
        if (response.getStatusCode() >= 400) {
            logger.error("Could not access the url {}", url + response.getStatusCode());
        } else {
            logger.info("Successfully accessed page {}", url);
        }
        return response;
    }

    public Response postRequest(String url, String queryParams) {
        response = request.post(url + "?" + queryParams);
        logger.debug("Successfully post the request {}", url + "?" + queryParams);
        if (response.getStatusCode() >= 400) {
            logger.error("Could not send the post request to url {}, with body {}", url + response.getStatusCode(), response.getBody().asString());
        } else {
            logger.debug("Successfully send the post request to url {}", url);
        }
        return response;
    }

}
