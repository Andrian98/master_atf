package performance.upskilling.atf.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserActionsStepsImpl {

    private static final Logger logger = LogManager.getLogger(UserActionsStepsImpl.class);

    WebDriver driver;
    WebDriverWait wait;

    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.tagName("button");
    By buzzButton = By.xpath("//span[text()='Buzz']");
    By postInput = By.className("oxd-buzz-post-input");
    By postButton = By.xpath("//button[@type='submit']");
    By postValidation = By.xpath("//p[text()='My ATF is working']");
    By threeDots = By.xpath("//i[@class='oxd-icon bi-three-dots']");
    By deletePost = By.xpath("//p[text()='Delete Post']");
    By yesDeleteButton = By.xpath("//button[text()=' Yes, Delete ']");
    By successMessage = By.xpath("//div[contains(@class,'oxd-toast oxd-toast--success')]");
    By userDropDown = By.className("oxd-userdropdown-name");
    By changePasswordButton = By.xpath("(//a[@class='oxd-userdropdown-link'])[3]");
    By currentPassword = By.xpath("//input[@type='password']");
    By newPassword = By.xpath("(//input[@type='password'])[2]");
    By confirmPassword = By.xpath("(//input[@type='password'])[3]");
    By saveButton = By.xpath("//button[@type='submit']");
    By userLoggedIn = By.className("oxd-sidepanel-body");
    By userLoggedOut = By.xpath("//a[@href='/web/index.php/auth/logout']");
    By validateTopUp = By.xpath("//p[text()='The selected item will be permanently deleted. Are you sure you want to continue?']");

    public UserActionsStepsImpl(WebDriver driver) {
        this.driver = driver;
        wait = WebDriverWaiter.getWaiter(driver);
    }

    public void validateTopUpMessage() {
        logger.debug("Waiting for the top up message to be displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(validateTopUp));
        logger.info("Top up message is displayed");
    }

    public void clickLogOutButton() {
        try {
            logger.debug("Waiting for Logout button to be visible");
            wait.until(ExpectedConditions.visibilityOfElementLocated(userLoggedOut));
            logger.debug("Clicking Logout button");
            driver.findElement(userLoggedOut).click();
            logger.info("User clicked Logout button");
        } catch (Exception e) {
            logger.error("Error clicking Logout button: {}", e.getMessage());
        }
    }

    public void clickSaveButton() {
        try {
            logger.debug("Clicking Save button");
            driver.findElement(saveButton).click();
            logger.info("User clicked Save button");
        } catch (Exception e) {
            logger.error("Error clicking Save button: {}", e.getMessage());
        }
    }

    public void insertConfirmPassword(String newPass) {
        try {
            logger.debug("Inserting confirm password");
            driver.findElement(confirmPassword).sendKeys(newPass);
            logger.info("User inserted confirm password");
        } catch (Exception e) {
            logger.error("Error inserting confirm password: {}", e.getMessage());
        }
    }

    public void clickConfirmPassword() {
        try {
            logger.debug("Clicking Confirm Password field");
            driver.findElement(confirmPassword).click();
            logger.info("User clicked Confirm Password field");
        } catch (Exception e) {
            logger.error("Error clicking Confirm Password field: {}", e.getMessage());
        }
    }

    public void insertNewPassword(String newPass) {
        try {
            logger.debug("Inserting new password");
            driver.findElement(newPassword).sendKeys(newPass);
            logger.info("User inserted new password");
        } catch (Exception e) {
            logger.error("Error inserting new password: {}", e.getMessage());
        }
    }

    public void clickPasswordField() {
        try {
            logger.debug("Clicking Password field");
            driver.findElement(newPassword).click();
            logger.info("User clicked Password insert field");
        } catch (Exception e) {
            logger.error("Error clicking Password field: {}", e.getMessage());
        }
    }

    public void insertOldPassword(String password) {
        try {
            logger.debug("Inserting old password");
            driver.findElement(currentPassword).sendKeys(password);
            logger.info("User inserted old password");
        } catch (Exception e) {
            logger.error("Error inserting old password: {}", e.getMessage());
        }
    }

    public void clickCurrentPasswordField() {
        try {
            logger.debug("Waiting for Current Password field to be visible");
            wait.until(ExpectedConditions.visibilityOfElementLocated(currentPassword));
            logger.debug("Clicking Current Password field");
            driver.findElement(currentPassword).click();
            logger.info("User clicked Current Password field");
        } catch (Exception e) {
            logger.error("Error clicking Current Password field: {}", e.getMessage());
        }
    }

    public void navigateToLoginPage(String appURL) {
        try {
            logger.debug("Navigating to login page: {}", appURL);
            driver.get(appURL);
            logger.info("User navigated to login page");
        } catch (Exception e) {
            logger.error("Error navigating to login page: {}", e.getMessage());
        }
    }

    public void enterCredentials(String username, String password) {
        try {
            logger.debug("Entering credentials");
            WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
            WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
            usernameElement.sendKeys(username);
            passwordElement.sendKeys(password);
            logger.info("User entered credentials");
        } catch (Exception e) {
            logger.error("Error entering credentials: {}", e.getMessage());
        }
    }

    public void clickLoginButton() {
        try {
            logger.debug("Clicking Login button");
            driver.findElement(loginButton).click();
            logger.info("User clicked Login button");
        } catch (Exception e) {
            logger.error("Error clicking Login button: {}", e.getMessage());
        }
    }

    public void validateDashboard(String appDashboard) {
        try {
            logger.debug("Validating dashboard URL: {}", appDashboard);
            wait.until(ExpectedConditions.urlToBe(appDashboard));
            logger.info("Dashboard URL validated");
        } catch (Exception e) {
            logger.error("Error validating dashboard URL: {}", e.getMessage());
        }
    }

    public void clickBuzzButton() {
        try {
            logger.debug("Waiting for Buzz button to be clickable");
            wait.until(ExpectedConditions.elementToBeClickable(buzzButton));
            logger.debug("Clicking Buzz button");
            driver.findElement(buzzButton).click();
            logger.info("User clicked Buzz button");
        } catch (Exception e) {
            logger.error("Error clicking Buzz button: {}", e.getMessage());
        }
    }

    public void clickPostInput() {
        try {
            logger.debug("Waiting for Post Input to be visible");
            wait.until(ExpectedConditions.visibilityOfElementLocated(postInput));
            logger.debug("Clicking Post Input");
            driver.findElement(postInput).click();
            logger.info("User clicked Post Input");
        } catch (Exception e) {
            logger.error("Error clicking Post Input: {}", e.getMessage());
        }
    }

    public void insertText(String text) {
        try {
            logger.debug("Inserting text into Post Input: {}", text);
            driver.findElement(postInput).sendKeys(text);
            logger.info("User inserted text into Post Input");
        } catch (Exception e) {
            logger.error("Error inserting text into Post Input: {}", e.getMessage());
        }
    }

    public void clickPostButton() {
        try {
            logger.debug("Clicking Post button");
            driver.findElement(postButton).click();
            logger.info("User clicked Post button");
        } catch (Exception e) {
            logger.error("Error clicking Post button: {}", e.getMessage());
        }
    }

    public void postValidation() {
        try {
            logger.debug("Validating post");
            wait.until(ExpectedConditions.visibilityOfElementLocated(postValidation));
            logger.info("Post validated successfully");
        } catch (Exception e) {
            logger.error("Error validating post: {}", e.getMessage());
        }
    }

    public void validateBuzzboard(String appBuzzboard) {
        try {
            logger.debug("Validating Buzzboard URL: {}", appBuzzboard);
            wait.until(ExpectedConditions.urlToBe(appBuzzboard));
            logger.info("Buzzboard URL validated");
        } catch (Exception e) {
            logger.error("Error validating Buzzboard URL: {}", e.getMessage());
        }
    }

    public void userLoggedIn() {
        try {
            logger.debug("Validating user is logged in");
            wait.until(ExpectedConditions.visibilityOfElementLocated(userLoggedIn));
            logger.info("User is logged in");
        } catch (Exception e) {
            logger.error("Error validating user is logged in: {}", e.getMessage());
        }
    }

    public void clickThreeDots() {
        try {
            logger.debug("Clicking Three Dots button");
            driver.findElement(threeDots).click();
            logger.info("User clicked Three Dots button");
        } catch (Exception e) {
            logger.error("Error clicking Three Dots button: {}", e.getMessage());
        }
    }

    public void deletePost() {
        try {
            logger.debug("Waiting for Delete Post option to be visible");
            wait.until(ExpectedConditions.visibilityOfElementLocated(deletePost));
            logger.debug("Clicking Delete Post option");
            driver.findElement(deletePost).click();
            logger.info("User clicked Delete Post option");
        } catch (Exception e) {
            logger.error("Error clicking Delete Post option: {}", e.getMessage());
        }
    }

    public void clickYesDelete() {
        try {
            logger.debug("Waiting for Yes, Delete button to be visible");
            wait.until(ExpectedConditions.visibilityOfElementLocated(yesDeleteButton));
            logger.debug("Clicking Yes, Delete button");
            driver.findElement(yesDeleteButton).click();
            logger.info("User clicked Yes, Delete button");
        } catch (Exception e) {
            logger.error("Error clicking Yes, Delete button: {}", e.getMessage());
        }
    }

    public void validationSuccessMessage() {
        try {
            logger.debug("Validating success message");
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            logger.info("Success message validated");
        } catch (Exception e) {
            logger.error("Error validating success message: {}", e.getMessage());
        }
    }

    public void clickUserDropDown() {
        try {
            logger.debug("Clicking User Dropdown menu");
            driver.findElement(userDropDown).click();
            logger.info("User clicked User Dropdown menu");
        } catch (Exception e) {
            logger.error("Error clicking User Dropdown menu: {}", e.getMessage());
        }
    }

    public void clickChangePasswordButton() {
        try {
            logger.debug("Waiting for Change Password button to be visible");
            wait.until(ExpectedConditions.visibilityOfElementLocated(changePasswordButton));
            logger.debug("Clicking Change Password button");
            driver.findElement(changePasswordButton).click();
            logger.info("User clicked Change Password button");
        } catch (Exception e) {
            logger.error("Error clicking Change Password button: {}", e.getMessage());
        }
    }

    public void validateChangePasswordPage(String appPasswordBoard) {
        try {
            logger.debug("Validating Change Password page URL: {}", appPasswordBoard);
            wait.until(ExpectedConditions.urlToBe(appPasswordBoard));
            logger.info("Change Password page URL validated");
        } catch (Exception e) {
            logger.error("Error validating Change Password page URL: {}", e.getMessage());
        }
    }
}
