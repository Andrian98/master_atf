package performance.upskilling.atf.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.tagName("button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = WebDriverWaiter.getWaiter(driver);
    }

    public void navigateToLoginPage() {
        driver.get("http://172.23.176.163:8200/");
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

    public void validateDashboard() {
        wait.until(ExpectedConditions.urlToBe("http://172.23.176.163:8200/web/index.php/dashboard/index"));
    }

}
