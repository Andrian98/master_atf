package performance.upskilling.atf.ui.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pages.RegistrationPageImpl;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class RegistrationPageSteps {

    public static WebDriver driver = WebDriverManager.getDriver();
    public static RegistrationPageImpl registrationPageImpl = new RegistrationPageImpl(driver);
    public static String registerURL = PropertiesManager.getRegisterURL();


    @Given("user is on registration page")
    public void userIsOnRegistrationPage() {
        registrationPageImpl.navigateToRegistrationPage(registerURL);
    }

    @When("user fills out the registration form with the following details")
    public void userFillsOutTheRegistrationFormWithTheFollowingDetails(DataTable dataTable) {
        Map<String, String> userDetails = dataTable.transpose().asMap();
        registrationPageImpl.insertRegisterDetails(userDetails);
    }

    @When("user clicks register button")
    public void userClicksRegisterButton() {
        registrationPageImpl.clickRegisterButton();
    }

    @Then("user is successfully registered")
    public void userIsSuccessfullyRegistered() {
        registrationPageImpl.validateUserCreation();
    }

}
