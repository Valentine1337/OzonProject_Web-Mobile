package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.qameta.allure.Allure.step;

public class Testbase {

    @BeforeAll
    @DisplayName("Настраиваем браузер")
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = "https://www.ozon.ru";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

/*        if (Boolean.getBoolean("isRemote")) {
            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }*/
    }

    @AfterEach
    @DisplayName("Добавляем аттачменты")
    void addAttachments() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
        step("Закрываем WebDriver", () -> {
            Selenide.closeWebDriver();
        });
    }
}
