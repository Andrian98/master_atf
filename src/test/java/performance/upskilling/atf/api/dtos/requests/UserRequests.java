package performance.upskilling.atf.api.dtos.requests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;


public class UserRequests {

    public JSONObject getJsonObjectFromResponse(Response response) {
        String responseBody = response.getBody().asString();
        return new JSONObject(responseBody);
    }

    //TODO Maybe it's need to move in config or utility
    public static void setRestAssured(String url) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL, true, System.out))
                .addFilter(new RequestLoggingFilter(LogDetail.ALL, true, System.out));

        RestAssured.requestSpecification = requestSpecBuilder.build();

    }

}
