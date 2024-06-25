package performance.upskilling.atf;


import org.junit.Before;
import org.junit.Test;
import performance.upskilling.atf.api.dtos.requests.UserCreation;
import performance.upskilling.atf.api.dtos.response.UserCreationResponse;
import io.restassured.response.Response;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

public class TestRunnerAPI {
    private static UserCreation userCreation;
    private static UserCreationResponse userCreationResponse;
    private static final String adminUser = PropertiesManager.getAdminUser();
    private static final String adminPassword = PropertiesManager.getAdminPassword();



    @Before
    public void setup() {
        userCreation = new UserCreation();
        userCreationResponse = new UserCreationResponse();
    }

    @Test
    public void testCreateUser() {
        Response response;

        response = userCreation.loginAsAdmin(adminUser, adminPassword);
        userCreationResponse.validateLoginAdmin(response);
//        response = userCreation.createUser("newuser", "newpassword", "newuser@example.com");
//        userCreationResponse.validateCreatedResponse(response);
    }
}
