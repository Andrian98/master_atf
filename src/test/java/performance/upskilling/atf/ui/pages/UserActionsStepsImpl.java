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


}
