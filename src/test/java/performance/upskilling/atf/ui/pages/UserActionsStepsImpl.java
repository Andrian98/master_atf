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

    public void validateDashboard(String appURL) {
        wait.until(ExpectedConditions.urlToBe(appURL + "web/index.php/dashboard/index"));
    }

}
