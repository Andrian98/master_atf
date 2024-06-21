package performance.upskilling.atf.ui.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pages.UserActionsStepsImpl;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserActionsSteps {

    private static final Logger logger = LogManager.getLogger(UserActionsSteps.class);

    WebDriver driver = WebDriverManager.getDriver();
    UserActionsStepsImpl userActionsStepsImpl = new UserActionsStepsImpl(driver);
    String username = PropertiesManager.getUsername();
    String oldPassword = PropertiesManager.getPassword();
    String appURL = PropertiesManager.getAppURL();
    String appDashboard = PropertiesManager.getAppDashboard();
    String appBuzzboard = PropertiesManager.getAppBuzzboard();
    String appPasswordBoard = PropertiesManager.getAppPasswordBoard();
    String newPassword = PropertiesManager.getNewPassword();

    @Given("user is on Home page")
    public void userIsOnHomePage() {
        logger.debug("Navigating to login page");
        userActionsStepsImpl.navigateToLoginPage(appURL);
        logger.info("User is on Home page");
    }

    @When("user enters their credentials")
    public void userEntersTheirCredentials() {
        logger.debug("Entering credentials: username={}, password={}", username, oldPassword);
        userActionsStepsImpl.enterCredentials(username, oldPassword);
        logger.info("User entered their credentials");
    }

    @And("user clicks Login button")
    public void userClicksLoginButton() {
        logger.debug("Clicking Login button");
        userActionsStepsImpl.clickLoginButton();
        logger.info("User clicked Login button");
    }

    @Then("user is redirected to the dashboard")
    public void userIsRedirectedToTheDashboard() {
        logger.debug("Validating dashboard");
        userActionsStepsImpl.validateDashboard(appDashboard);
        logger.info("User is redirected to the dashboard");
    }

    @Given("user is logged in")
    public void user_is_logged_in() {
        logger.debug("User is logged in");
        userActionsStepsImpl.userLoggedIn();
        logger.info("User is logged in");
    }

    @When("user clicks Buzz meniu")
    public void user_clicks_Buzz_meniu() {
        logger.debug("Clicking Buzz menu");
        userActionsStepsImpl.clickBuzzButton();
        logger.info("User clicked Buzz menu");
    }

    @When("user clicks on text input bar")
    public void user_clicks_on_text_input_bar() {
        logger.debug("Clicking on text input bar");
        userActionsStepsImpl.clickPostInput();
        logger.info("User clicked on text input bar");
    }

    @When("user insert the text {string}")
    public void user_insert_the_text(String string) {
        logger.debug("Inserting text: {}", string);
        userActionsStepsImpl.insertText(string);
        logger.info("User inserted the text");
    }

    @When("user clicks Post button")
    public void user_clicks_Post_button() {
        logger.debug("Clicking Post button");
        userActionsStepsImpl.clickPostButton();
        logger.info("User clicked Post button");
    }

    @Then("post is displayed on Buzz Newsfeed")
    public void post_is_displayed_on_buzz_newsfeed() {
        logger.debug("Validating post on Buzz Newsfeed");
        userActionsStepsImpl.postValidation();
        logger.info("Post is displayed on Buzz Newsfeed");
    }

    @Given("user is on Buzz board")
    public void user_is_on_buzz_board() {
        logger.debug("Validating Buzz board");
        userActionsStepsImpl.validateBuzzboard(appBuzzboard);
        logger.info("User is on Buzz board");
    }

    @When("user clicks on three dots button")
    public void user_clicks_on_three_dots_button() {
        logger.debug("Clicking on three dots button");
        userActionsStepsImpl.clickThreeDots();
        logger.info("User clicked on three dots button");
    }

    @When("user clicks on Delete Post option")
    public void user_clicks_on_delete_post_option() {
        logger.debug("Clicking on Delete Post option");
        userActionsStepsImpl.deletePost();
        logger.info("User clicked on Delete Post option");
    }

    @When("user clicks Yes,Delete button")
    public void user_clicks_yes_delete_button() {
        logger.debug("Clicking Yes,Delete button");
        userActionsStepsImpl.clickYesDelete();
        logger.info("User clicked Yes,Delete button");
    }


    @Then("post is successfully deleted")
    public void post_is_successfully_deleted() {
        logger.debug("Validating post deletion");
        userActionsStepsImpl.validationSuccessMessage();
        logger.info("Post is successfully deleted");
    }

    @When("user clicks userdropdown meniu")
    public void user_clicks_userdropdown_meniu() {
        logger.debug("Clicking user dropdown menu");
        userActionsStepsImpl.clickUserDropDown();
        logger.info("User clicked user dropdown menu");
    }

    @When("user clicks Change Password button")
    public void user_clicks_change_password_button() {
        logger.debug("Clicking Change Password button");
        userActionsStepsImpl.clickChangePasswordButton();
        logger.info("User clicked Change Password button");
    }

    @When("update password page is displayed")
    public void update_password_page_is_displayed() {
        logger.debug("Validating Change Password page");
        userActionsStepsImpl.validateChangePasswordPage(appPasswordBoard);
        logger.info("Update password page is displayed");
    }

    @When("user clicks on Current Password insert bar")
    public void user_clicks_on_current_password_insert_bar() {
        logger.debug("Clicking on Current Password insert bar");
        userActionsStepsImpl.clickCurrentPasswordField();
        logger.info("User clicked on Current Password insert bar");
    }

    @When("user insert current password")
    public void user_insert_current_password() {
        logger.debug("Inserting current password: {}", oldPassword);
        userActionsStepsImpl.insertOldPassword(oldPassword);
        logger.info("User inserted current password");
    }

    @When("user clicks on Password insert bar")
    public void user_clicks_on_password_insert_bar() {
        logger.debug("Clicking on Password insert bar");
        userActionsStepsImpl.clickPasswordField();
        logger.info("User clicked on Password insert bar");
    }

    @When("user insert new password")
    public void user_insert_new_password() {
        logger.debug("Inserting new password: {}", newPassword);
        userActionsStepsImpl.insertNewPassword(newPassword);
        logger.info("User inserted new password");
    }

    @When("user clicks on Confirm Password insert bar")
    public void user_clicks_on_confirm_password_insert_bar() {
        logger.debug("Clicking on Confirm Password insert bar");
        userActionsStepsImpl.clickConfirmPassword();
        logger.info("User clicked on Confirm Password insert bar");
    }

    @When("user insert new password again")
    public void user_insert_new_password_again() {
        logger.debug("Inserting new password again: {}", newPassword);
        userActionsStepsImpl.insertConfirmPassword(newPassword);
        logger.info("User inserted new password again");
    }

    @When("user clicks on Save button")
    public void user_clicks_on_save_button() {
        logger.debug("Clicking on Save button");
        userActionsStepsImpl.clickSaveButton();
        logger.info("User clicked on Save button");
    }

    @Then("password is updated")
    public void password_is_updated() {
        logger.debug("Validating password update");
        userActionsStepsImpl.validationSuccessMessage();
        logger.info("Password is updated");
    }

    @And("user insert current new password")
    public void user_insert_current_new_password() {
        logger.debug("Inserting current new password: {}", newPassword);
        userActionsStepsImpl.insertOldPassword(newPassword);
        logger.info("User inserted current new password");
    }

    @When("user insert old password")
    public void user_insert_old_password() {
        logger.debug("Inserting old password: {}", oldPassword);
        userActionsStepsImpl.insertNewPassword(oldPassword);
        logger.info("User inserted old password");
    }

    @When("user insert old password again")
    public void user_insert_old_password_again() {
        logger.debug("Inserting old password again: {}", oldPassword);
        userActionsStepsImpl.insertConfirmPassword(oldPassword);
        logger.info("User inserted old password again");
    }

    @Then("old password is restored")
    public void old_password_is_restored() {
        logger.debug("Validating old password restoration");
        userActionsStepsImpl.validationSuccessMessage();
        logger.info("Old password is restored");
    }

    @When("user clicks Logout button")
    public void user_clicks_logout_button() {
        logger.debug("Clicking Logout button");
        userActionsStepsImpl.clickLogOutButton();
        logger.info("User clicked Logout button");
    }

    @Then("user logged out")
    public void user_logged_out() {
        logger.debug("Navigating to login page after logout");
        userActionsStepsImpl.navigateToLoginPage(appURL);
        logger.info("User logged out");
    }
}
