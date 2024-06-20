package performance.upskilling.atf.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;
import performance.upskilling.atf.ui.steps.UserActionsSteps;

public class UserActionsStepsImpl {

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
    By successeMessage = By.xpath("//div[contains(@class,'oxd-toast oxd-toast--success')]");
    By userDropDown = By.className("oxd-userdropdown-name");
    By changePasswordButton = By.xpath("(//a[@class='oxd-userdropdown-link'])[3]");
    By currentPassword = By.xpath("//input[@class='oxd-input oxd-input--focus']");
    By password = By.xpath("(//input[@type='password'])[2]");
    By confirmPassword = By.xpath("(//input[@type='password'])[3]");
    By saveButton = By.xpath("//button[@type='submit']");
    By userLoggedIn = By.className("oxd-sidepanel-body");

    public UserActionsStepsImpl(WebDriver driver) {
        this.driver = driver;
        wait = WebDriverWaiter.getWaiter(driver);
    }

    public void navigateToLoginPage(String appURL) {
        driver.get(appURL);
    }

    public void enterCredentials(String username, String password) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));

        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void validateDashboard(String appDashboard) {
        wait.until(ExpectedConditions.urlToBe(appDashboard));
    }

    public void clickBuzzButton() {
        wait.until(ExpectedConditions.elementToBeClickable(buzzButton));
        driver.findElement(buzzButton).click();
    }

    public void clickPostInput() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postInput));
        driver.findElement(postInput).click();
    }

    public void insertText(String text) {
        driver.findElement(postInput).sendKeys(text);
    }

    public void clickPostButton() {
        driver.findElement(postButton).click();
    }

    public void postValidation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postValidation));
        driver.findElement(postValidation);
    }

    public void validateBuzzboard(String appBuzzboard) {
        wait.until(ExpectedConditions.urlToBe(appBuzzboard));
    }

    public void userLoggedIn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userLoggedIn));
    }

    public void clickThreeDots(){
        driver.findElement(threeDots).click();
    }

    public void deletePost(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(deletePost));
        driver.findElement(deletePost).click();
    }

    public void clickYesDelete(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(yesDeleteButton));
        driver.findElement(yesDeleteButton).click();
    }

    public void validationSuccessMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(successeMessage));
    }

    public void clickUserDropDown(){
        driver.findElement(userDropDown).click();
    }

    public void clickChangePassword(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(changePasswordButton));
        driver.findElement(changePasswordButton).click();
    }

    public void validatePasswordBoard(String appPasswordBoard){
        wait.until(ExpectedConditions.urlToBe(appPasswordBoard));
    }


}
