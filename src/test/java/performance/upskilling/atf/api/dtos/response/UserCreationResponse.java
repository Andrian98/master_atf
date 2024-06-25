package performance.upskilling.atf.api.dtos.response;

import io.restassured.response.Response;

public class UserCreationResponse {

    public void validateLoginAdmin(Response response){
        response.then().statusCode(302);
    }

    public void validateCreatedResponse(Response response) {
        response.then().statusCode(200);
        // Add more validation logic here, if needed
    }
}
