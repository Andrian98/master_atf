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
    // TODO add access modifiers put the correct type
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
    public void user_is_on_home_page() {
        userActionsStepsImpl.navigateToLoginPage(appURL);
    }

    // TODO to use WHEN instead of the AND
    // TODO Optimese the methods ex. Click on the button (web element) universal logger
    // TODO validation with assert
    @When("user enters their credentials")
    public void userEntersTheirCredentials() {
        userActionsStepsImpl.enterCredentials(username, oldPassword);
    }

    @And("user clicks Login button")
    public void user_clicks_login_button() {
        userActionsStepsImpl.clickLoginButton();
    }

    @Then("user is redirected to the dashboard")
    public void user_is_redirected_to_the_dashboard() {
        userActionsStepsImpl.validateDashboard(appDashboard);
        logger.info("User is redirected to the dashboard");
    }

    @Given("user is logged in")
    public void user_is_logged_in() {
        userActionsStepsImpl.userLoggedIn();
    }

    @When("user clicks Buzz meniu")
    public void user_clicks_Buzz_meniu() {
        userActionsStepsImpl.clickBuzzButton();
    }

    @Then("Buzz page is displayed")
    public void buzz_page_is_displayed() {
        userActionsStepsImpl.validateBuzzboard(appBuzzboard);
        logger.info("Buzz page is displayed");
    }

    @When("user clicks on text input bar")
    public void user_clicks_on_text_input_bar() {
        userActionsStepsImpl.clickPostInput();
    }

    @And("user insert the text {string}")
    public void user_insert_the_text(String string) {
        userActionsStepsImpl.insertText(string);
    }

    @And("user clicks Post button")
    public void user_clicks_Post_button() {
        userActionsStepsImpl.clickPostButton();
    }

    @Then("post is displayed on Buzz Newsfeed")
    public void post_is_displayed_on_buzz_newsfeed() {
        userActionsStepsImpl.postValidation();
        logger.info("Post is displayed on Buzz Newsfeed");
    }

    @Given("user is on Buzz board")
    public void user_is_on_buzz_board() {
        userActionsStepsImpl.validateBuzzboard(appBuzzboard);
        logger.info("User is on Buzz board");
    }

    @When("user clicks on three dots button")
    public void user_clicks_on_three_dots_button() {
        userActionsStepsImpl.clickThreeDots();
    }

    @And("user clicks on Delete Post option")
    public void user_clicks_on_delete_post_option() {
        userActionsStepsImpl.deletePost();
    }

    @Then("top up is displayed")
    public void top_up_is_displayed() {
        userActionsStepsImpl.validateTopUpMessage();
    }

    @When("user clicks Yes,Delete button")
    public void user_clicks_yes_delete_button() {
        userActionsStepsImpl.clickYesDelete();
    }

    @Then("post is successfully deleted")
    public void post_is_successfully_deleted() {
        userActionsStepsImpl.validationSuccessMessage();
        logger.info("Post is successfully deleted");
    }

    @When("user clicks userdropdown meniu")
    public void user_clicks_userdropdown_meniu() {
        userActionsStepsImpl.clickUserDropDown();
    }

    @And("user clicks Change Password button")
    public void user_clicks_change_password_button() {
        userActionsStepsImpl.clickChangePasswordButton();
    }

    @Then("update password page is displayed")
    public void update_password_page_is_displayed() {
        userActionsStepsImpl.validateChangePasswordPage(appPasswordBoard);
        logger.info("Update password page is displayed");
    }

    @When("user clicks on Current Password insert bar")
    public void user_clicks_on_current_password_insert_bar() {
        userActionsStepsImpl.clickCurrentPasswordField();
    }

    @When("user insert current password")
    public void user_insert_current_password() {
        userActionsStepsImpl.insertOldPassword(oldPassword);
        logger.info("User inserted current (old) password");
    }

    @And("user clicks on Password insert bar")
    public void user_clicks_on_password_insert_bar() {
        userActionsStepsImpl.clickPasswordField();
    }

    @And("user insert new password")
    public void user_insert_new_password() {
        userActionsStepsImpl.insertNewPassword(newPassword);
    }

    @And("user clicks on Confirm Password insert bar")
    public void user_clicks_on_confirm_password_insert_bar() {
        userActionsStepsImpl.clickConfirmPassword();
    }

    @And("user insert new password again")
    public void user_insert_new_password_again() {
        userActionsStepsImpl.insertConfirmPassword(newPassword);
        logger.info("User inserted new password again");
    }

    @And("user clicks on Save button")
    public void user_clicks_on_save_button() {
        userActionsStepsImpl.clickSaveButton();
    }

    @Then("password is updated")
    public void password_is_updated() {
        userActionsStepsImpl.validationSuccessMessage();
        logger.info("Password is updated");
    }

    @And("user insert current new password")
    public void user_insert_current_new_password() {
        userActionsStepsImpl.insertOldPassword(newPassword);
        logger.info("User inserted current new password");
    }

    @And("user insert old password")
    public void user_insert_old_password() {
        userActionsStepsImpl.insertNewPassword(oldPassword);
    }

    @And("user insert old password again")
    public void user_insert_old_password_again() {
        userActionsStepsImpl.insertConfirmPassword(oldPassword);
        logger.info("User inserted old password again");
    }

    @Then("old password is restored")
    public void old_password_is_restored() {
        userActionsStepsImpl.validationSuccessMessage();
        logger.info("Old password is restored");
    }

    @When("user clicks Logout button")
    public void user_clicks_logout_button() {
        userActionsStepsImpl.clickLogOutButton();
    }

    @Then("user logged out")
    public void user_logged_out() {
        userActionsStepsImpl.navigateToLoginPage(appURL);
        logger.info("User logged out");
    }
}
