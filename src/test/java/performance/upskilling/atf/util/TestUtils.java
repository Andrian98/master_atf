package performance.upskilling.atf.util;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pageobjects.LoginPageElements;

import static performance.upskilling.atf.configuration.driverfactory.WebDriverManager.driver;
import static performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter.wait;

//TODO change the class name to the TestCustomActions ...
public class TestUtils {
    private static final Logger logger = LogManager.getLogger();

    public static void setRestAssured(String url) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON);

        RestAssured.requestSpecification = requestSpecBuilder.build();
        logger.info("RestAssured set up");
    }
//TODO try to use Hamcrest assertions instead of the Assertj
    public void assertPageText(String expectedText, String actualText) {
        Assertions.assertThat(actualText).isEqualTo(expectedText);
        logger.info("\nActual text: {} \nExpected text: {}", actualText, expectedText);
    }

    public void sendKeysToWebElement(WebElement webElement, String keysToSend) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();

        webElement.sendKeys(keysToSend);
        logger.debug("Send {} keys to {} WebElement", keysToSend, webElement);
    }

    public void navigateTo(String url) {
        logger.debug("Validating provided URL: {}", url);
        driver.navigate().to(url);
        logger.info("Provided URL are validated");
    }

}
