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

import static configs.web.Web.webConfig;
import static io.qameta.allure.Allure.step;

public class TestbaseWeb {

    @BeforeAll
    @DisplayName("Настраиваем браузер")
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        //Set settings based on remote or local run
        Configuration.baseUrl = System.getProperty("standHost");
        if (webConfig.isRemote()) {
            Configuration.remote = "https://" + webConfig.selenoidUser() + ":"
                    + webConfig.selenoidPassword() +
                    "@selenoid.autotests.cloud/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", webConfig.browserName());
            capabilities.setCapability("browserVersion", webConfig.browserVersion());
            capabilities.setCapability("browserSize", webConfig.browserSize());
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        } else {
            Configuration.browserSize = webConfig.browserSize();
            Configuration.browser = webConfig.browserName();
            Configuration.browserVersion = webConfig.browserVersion();
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
