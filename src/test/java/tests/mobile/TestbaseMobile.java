package tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.DriverSwitcher;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attachments.getSessionId;
import static io.qameta.allure.Allure.step;

public class TestbaseMobile {
    private static String selectedDevice = System.getProperty("deviceHost");

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = DriverSwitcher.getDriver(selectedDevice);
        Configuration.browserSize = null;
    }

    @AfterEach
    public void afterEach() {
        if (selectedDevice.equals("browserstack")) {
            String sessionId = getSessionId();
            Attachments.screenshotAs("Last screenshot");
            Attachments.pageSource();
            Attachments.addVideoBrowserstack(sessionId);
        } else {
            Attachments.screenshotAs("Last screenshot");
            Attachments.pageSource();
        }
        step("Close webdriver", Selenide::closeWebDriver);
    }
}
