package performance.upskilling.atf;


import org.junit.Before;
import org.junit.Test;
import performance.upskilling.atf.api.actions.AdminUserSteps;
import performance.upskilling.atf.api.dtos.requests.AdminUserRequests;
import performance.upskilling.atf.api.dtos.response.AdminUserResponse;
import io.restassured.response.Response;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

public class TestRunnerAPI {
    private static AdminUserRequests userCreation;
    private static AdminUserResponse userCreationResponse;
    private static AdminUserSteps adminUserSteps;
    private static final String adminUser = PropertiesManager.getAdminUser();
    private static final String adminPassword = PropertiesManager.getAdminPassword();


    @Before
    public void setup() {
        adminUserSteps = new AdminUserSteps();
    }

    @Test
    public void testCreateUser() {
        adminUserSteps.ISendAPostRequestToTheLoginEndpoint(adminUser, adminPassword);
        adminUserSteps.IAmAnAuthorizedUser();
    }
}
