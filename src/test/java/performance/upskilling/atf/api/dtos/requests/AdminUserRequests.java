package performance.upskilling.atf.api.dtos.requests;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AdminUserRequests {

    public static String tokenExtractor() {
        // Set up the base URL for the API
        RestAssured.baseURI = PropertiesManager.getAppLogin();

        RequestSpecification request = RestAssured.given()
                .header("Content-Type", "text/plain");

        Response loginResponse = request.get();
        String htmlResponse = loginResponse.getBody().asString();
        String regex = ":token=\"&quot;([^\"]+)&quot;\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(htmlResponse);

        String tokenValue = null;
        if (matcher.find()) {
            tokenValue = matcher.group(1);
        }

        return tokenValue;
    }
}
