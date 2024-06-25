package performance.upskilling.atf.api.dtos.requests;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserCreation {
    private static Response authResponse;

    public String tokenExtractor() {
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

    public Response loginAsAdmin (String adminUsername, String adminPassword){
        RestAssured.baseURI = PropertiesManager.getAppAuth();
        RequestSpecification request = RestAssured.given()
                .header("Content-Type", "text/plain");

        Response loginResponse = request.get();
        Map<String, String> cookies = loginResponse.getCookies();

        String json = "{\"_token\":\"" + tokenExtractor() + "\",\"username\":\"" + adminUsername + "\",\"password\":\"" + adminPassword + "\"}";
        authResponse = request.cookies(cookies)
                .body(json)
                .post();

        return authResponse;
    }

    public Response createUser(String newUsername, String newPassword, String newEmail) {
        // Send a POST request to the /users endpoint to create a new user
        return RestAssured.given()
                .header("Authorization", "Bearer " + tokenExtractor())
                .header("Content-Type", "application/json")
                .body("{\"username\":\"" + newUsername + "\",\"password\":\"" + newPassword + "\",\"email\":\"" + newEmail + "\"}")
                .post("/users");
    }

}
