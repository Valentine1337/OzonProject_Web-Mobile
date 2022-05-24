package tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static configs.web.WebSelenide.webSelenideConfig;
import static io.qameta.allure.Allure.step;

public class TestbaseWeb {

    @BeforeAll
    @DisplayName("Настраиваем браузер")
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        //Set settings based on remote or local run
        Configuration.pageLoadTimeout = 30000;
        Configuration.baseUrl = System.getProperty("standHost");
        if (webSelenideConfig.isRemote()) {
            Configuration.remote = "https://" + webSelenideConfig.selenoidUser() + ":"
                    + webSelenideConfig.selenoidPassword() +
                    "@selenoid.autotests.cloud/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", webSelenideConfig.browserName());
            capabilities.setCapability("browserVersion", webSelenideConfig.browserVersion());
            capabilities.setCapability("browserSize", webSelenideConfig.browserSize());
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        } else {
            Configuration.browserSize = webSelenideConfig.browserSize();
            Configuration.browser = webSelenideConfig.browserName();
            Configuration.browserVersion = webSelenideConfig.browserVersion();
        }
    }

    @AfterEach
    @DisplayName("Добавляем аттачменты")
    public void addAttachments() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideoWeb();
        step("Закрываем WebDriver", Selenide::closeWebDriver);
    }
}
