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

    private static final Logger logger = LogManager.getLogger(RegistrationPageSteps.class);
    public static WebDriver driver = WebDriverManager.getDriver();
    public static RegistrationPageImpl registrationPageImpl = new RegistrationPageImpl(driver);
    public static String registerURL = PropertiesManager.getRegisterURL();


    @Given("user is on registration page")
    public void userIsOnRegistrationPage() {
        registrationPageImpl.navigateToRegistrationPage(registerURL);
    }

    @When("user fills out the registration form with the following details")
    public void userFillsOutTheRegistrationFormWithTheFollowingDetails(DataTable dataTable) {
        //TODO to make a method for the list, send a map as parameter to the method
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> user : data) {
            String firstName = user.get("First Name");
            String lastName = user.get("Last Name");
            String address = user.get("Address");
            String city = user.get("City");
            String state = user.get("State");
            String zipCode = user.get("Zip Code");
            String ssn = user.get("SSN");
            String username = user.get("Username");
            String password = user.get("Password");
            String confirmPassword = user.get("Confirm");

            registrationPageImpl.insertRegisterDetails(firstName, lastName, address, city, state, zipCode, ssn, username, password, confirmPassword);
        }
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
