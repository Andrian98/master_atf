package performance.upskilling.atf.api.hooks;

import io.cucumber.java.Before;
import performance.upskilling.atf.api.dtos.requests.UserRequests;
import performance.upskilling.atf.configuration.properties.PropertiesManager;

public class APIHooks {

    @Before
    public static void beforeAll() {
        UserRequests.setRestAssured(PropertiesManager.getURL());
    }
}
