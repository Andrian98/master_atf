package performance.upskilling.atf.api.dtos.response;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class LoginResponse {
    private String title;

    public LoginResponse(String response) {
        Document doc = Jsoup.parse(response);
        this.title = doc.select("title").text();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
