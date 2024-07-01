package performance.upskilling.atf.api.actions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import performance.upskilling.atf.api.dtos.requests.UserRequests;
import performance.upskilling.atf.api.dtos.response.UserResponse;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

import java.util.List;
import java.util.Map;

public class UserSteps {
    private static Response response;
    private static final UserResponse USER_RESPONSE = new UserResponse();

    //TODO Implement the assertions in the steps
    @Given("admin user logs in with the following credentials")
    public void adminUserLogsInWithTheFollowingCredentials(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps();
        String adminUsername = data.get(0).get("username");
        String adminPassword = data.get(0).get("password");

        RestAssured.baseURI = PropertiesManager.getAppLogin();
        RequestSpecification request = RestAssured.given();
        response = request.get();
        USER_RESPONSE.validateResponse200(response);

        RestAssured.baseURI = PropertiesManager.getAppAuth();
        request = RestAssured.given()
                .header("Content-Type", "text/plain");

        Response loginResponse = request.get();
        Map<String, String> cookies = loginResponse.getCookies();
        String json = "{\"_token\":\"" + UserRequests.tokenExtractor() + "\",\"username\":\"" + adminUsername + "\",\"password\":\"" + adminPassword + "\"}";
        response = request.cookies(cookies)
                .body(json)
                .post();

        USER_RESPONSE.validateLoginAdmin(response);

        System.out.println("It was the GIVEN ");
    }

    @When("admin navigates to PIM Add employee page")
    public void adminNavigatesToPIMAddEmployeePage() {
        //TODO implement the step
    }

    @And("admin insert employee details")
    public void adminInsertEmployeeDetails() {
        //TODO implement the step
    }

    @Then("new employee is created")
    public void newEmployeeIsCreated() {
        //TODO implement the step
    }
}
