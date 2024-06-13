package performance.upskilling.atf.ui.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pages.LoginPage;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;

public class LoginSteps {

    WebDriver driver = WebDriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    String username = PropertiesManager.getUsername();
    String password = PropertiesManager.getPassword();

    @Given("user is on Home page")
    public void userIsOnHomePage() {
        loginPage.navigateToLoginPage();
    }

    @When("user enters their credentials")
    public void userEntersTheirCredentials() {
         loginPage.enterCredentials(username,password);
    }

    @And("user clicks Login button")
    public void userClicksLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("user is redirected to the dashboard")
    public void userIsRedirectedToTheDashboard() {
        loginPage.validateDashboard();
    }
}
