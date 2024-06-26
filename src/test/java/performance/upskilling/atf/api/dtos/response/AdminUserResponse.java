package performance.upskilling.atf.api.dtos.response;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import performance.upskilling.atf.api.dtos.requests.AdminUserRequests;

public class AdminUserResponse {

    public void validateLoginAdmin(Response response){
        response.then().statusCode(302);
    }

    public void validateCreatedResponse(Response response) {
        response.then().statusCode(200);
        // Add more validation logic here, if needed
    }

    public Response createUser(String newUsername, String newPassword, String newEmail) {

        return RestAssured.given()
                .header("Authorization", "Bearer " + AdminUserRequests.tokenExtractor())
                .header("Content-Type", "application/json")
                .body("{\"username\":\"" + newUsername + "\",\"password\":\"" + newPassword + "\",\"email\":\"" + newEmail + "\"}")
                .post("/users");
    }
}
