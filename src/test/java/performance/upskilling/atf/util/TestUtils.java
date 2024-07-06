package performance.upskilling.atf.util;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;



public class TestUtils {
    private static final Logger logger = LogManager.getLogger();

    public static void setRestAssured(String url) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
//                .addFilter(new ResponseLoggingFilter(LogDetail.ALL, true, System.out))
//                .addFilter(new RequestLoggingFilter(LogDetail.ALL, true, System.out))
                ;

        RestAssured.requestSpecification = requestSpecBuilder.build();
        logger.info("RestAssured set up");
    }

    public void assertPageText(String expectedText, String actualText) {
        Assertions.assertThat(actualText).isEqualTo(expectedText);
        logger.info("Page text found: {}", actualText);
    }

    //TODO best practice to use response for assertion and validation
    //TODO best practice is to use json to parse the body
    //TODO make difference between what you request and response
    public String extractPageTitle(String url) {
        logger.debug("Extracting page title from {}", url);
        String responseBody = RestAssured.given()
                .get(url)
                .getBody()
                .asString();

        Document document = Jsoup.parse(responseBody);
        String title = document.title();
        logger.info("Extracted title: {}", title);
        return title;
    }

//    public String getPageTitle(String url) {
//        return WebDriverManager.getDriver().getTitle();
//    }
}
