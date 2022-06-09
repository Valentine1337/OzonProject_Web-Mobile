package helpers;

import static configs.mobile.Browserstack.*;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class BrowserstackVideo {
    public static String videoUrl(String sessionId) {
        String url = format("https://api-cloud.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(browserstackConfig.user(),
                        browserstackConfig.key())
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
