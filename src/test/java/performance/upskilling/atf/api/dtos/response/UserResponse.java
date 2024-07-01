package performance.upskilling.atf.api.dtos.response;

import io.restassured.response.Response;

public class UserResponse {

    public void validateLoginAdmin(Response response){
        response.then().statusCode(302);
        System.out.println("Validated the 302 response");
    }

    public void validateResponse200(Response response) {
        response.then().statusCode(200);
        System.out.println("Validated the 200 response");
    }

}
