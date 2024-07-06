package performance.upskilling.atf.api.dtos.requests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class UserRequests {
    public static final Logger logger = LogManager.getLogger(UserRequests.class);
    public static RequestSpecification requestSpecification;

    public static Document extractText(String url){
        logger.debug("Extracting document text from {}", url);
        String responseBody = RestAssured.given()
                .get(url)
                .getBody()
                .asString();
        return Jsoup.parse(responseBody);
    }
}
