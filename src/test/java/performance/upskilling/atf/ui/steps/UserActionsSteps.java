package performance.upskilling.atf.ui.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pages.UserActionsStepsImpl;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;

public class UserActionsSteps {

    WebDriver driver = WebDriverManager.getDriver();
    UserActionsStepsImpl userActionsStepsImpl = new UserActionsStepsImpl(driver);
    String username = PropertiesManager.getUsername();
    String password = PropertiesManager.getPassword();
    String appURL = PropertiesManager.getAppURL();
    String appDashboard = PropertiesManager.getAppDashboard();
    String appBuzzboard = PropertiesManager.getAppBuzzboard();

    @Given("user is on Home page")
    public void userIsOnHomePage() {
        userActionsStepsImpl.navigateToLoginPage(appURL);
    }

    @When("user enters their credentials")
    public void userEntersTheirCredentials() {
        userActionsStepsImpl.enterCredentials(username, password);
    }

    @And("user clicks Login button")
    public void userClicksLoginButton() {
        userActionsStepsImpl.clickLoginButton();
    }

    @Then("user is redirected to the dashboard")
    public void userIsRedirectedToTheDashboard() {
        userActionsStepsImpl.validateDashboard(appDashboard);
    }

    @Given("user is logged in")
    public void user_is_logged_in() {
        userActionsStepsImpl.validateDashboard(appDashboard);
    }

    @When("user clicks Buzz meniu")
    public void user_clicks_Buzz_meniu() {
        userActionsStepsImpl.clickBuzzButton();
    }

    @When("user clicks on text input bar")
    public void user_clicks_on_text_input_bar() {
        userActionsStepsImpl.clickPostInput();
    }

    @When("user insert the text {string}")
    public void user_insert_the_text(String string) {
        userActionsStepsImpl.insertText(string);
    }

    @When("user clicks Post button")
    public void user_clicks_Post_button() {
        userActionsStepsImpl.clickPostButton();
    }

    @Then("post is displayed on Buzz Newsfeed")
    public void post_is_displayed_on_buzz_newsfeed() {
        userActionsStepsImpl.postValidation();
    }

    @Given("user is on Buzz board")
    public void user_is_on_buzz_board() {
        userActionsStepsImpl.validateBuzzboard(appBuzzboard);
    }

    @When("user clicks on three dots button")
    public void user_clicks_on_three_dots_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on Delete Post option")
    public void user_clicks_on_delete_post_option() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks Yes,Delete button")
    public void user_clicks_yes_delete_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("post is successfully deleted")
    public void post_is_successfully_deleted() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks Change Password button")
    public void user_clicks_change_password_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("update password page is displayed")
    public void update_password_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on Current Password insert bar")
    public void user_clicks_on_current_password_insert_bar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user insert current password")
    public void user_insert_current_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on Password insert bar")
    public void user_clicks_on_password_insert_bar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user insert new password")
    public void user_insert_new_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on Confirm Password insert bar")
    public void user_clicks_on_confirm_password_insert_bar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user insert new password again")
    public void user_insert_new_password_again() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on Save button")
    public void user_clicks_on_save_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("password is updated")
    public void password_is_updated() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks userdropdown meniu")
    public void user_clicks_userdropdown_meniu() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user insert old password")
    public void user_insert_old_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user insert old password again")
    public void user_insert_old_password_again() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("old password is restored")
    public void old_password_is_restored() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks Logout button")
    public void user_clicks_logout_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user logged out")
    public void user_logged_out() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
