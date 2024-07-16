package performance.upskilling.atf.ui.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.common.assertion.Assertion;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pageobjects.RegistrationPageElements;
import performance.upskilling.atf.ui.pages.RegistrationPageImpl;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import performance.upskilling.atf.util.TestUtils;

import java.util.List;
import java.util.Map;

public class RegistrationPageSteps {
    public static RegistrationPageImpl registrationPageImpl = new RegistrationPageImpl(WebDriverManager.getDriver());
    public static String registerURL = PropertiesManager.getRegisterURL();
    public static TestUtils testUtils = new TestUtils();


    @Given("user is on registration page")
    public void userIsOnRegistrationPage() {
        registrationPageImpl.navigateToRegistrationPage(registerURL);
    }

    @When("user is registered filling out the registration form with the following details")
    public void userIsRegisteredFillingOutTheRegistrationFormWithTheFollowingDetails(DataTable dataTable) {
        Map<String, String> userDetails = dataTable.transpose().asMap();
        registrationPageImpl.insertRegisterDetails(userDetails);

        registrationPageImpl.clickRegisterButton();
    }

    @Then("webElement with message {string} is displayed")
    public void webElementWithMessageIsDisplayed(String expectedMessage) {
        testUtils.assertPageText(registrationPageImpl.validateUserCreation(), expectedMessage);
    }
}
