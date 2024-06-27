package performance.upskilling.atf.api.actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import performance.upskilling.atf.api.dtos.requests.AdminUserRequests;
import performance.upskilling.atf.api.dtos.response.AdminUserResponse;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

import java.util.Map;

public class AdminUserSteps {
    private static Response authResponse;
    AdminUserResponse adminUserResponse = new AdminUserResponse();

    @Given("I am an authorized user")
    public void IAmAnAuthorizedUser(){
        RestAssured.baseURI = PropertiesManager.getAppLogin();
        System.out.println("It was the GIVEN ");

    }

    @When("I send a POST request to the login endpoint")
    public void ISendAPostRequestToTheLoginEndpoint(String adminUsername, String adminPassword){
        RestAssured.baseURI = PropertiesManager.getAppAuth();
        RequestSpecification request = RestAssured.given()
                .header("Content-Type", "text/plain");

        Response loginResponse = request.get();
        Map<String, String> cookies = loginResponse.getCookies();
        String json = "{\"_token\":\"" + AdminUserRequests.tokenExtractor() + "\",\"username\":\"" + adminUsername + "\",\"password\":\"" + adminPassword + "\"}";
        authResponse = request.cookies(cookies)
                .body(json)
                .post();

        System.out.println("It was the WHEN ");
    }

    @Then("the response status code is 302")
    public void theResponseStatusCodeIs302(){
        adminUserResponse.validateLoginAdmin(authResponse);
        System.out.println("Validated the 302 response");
    }
}
