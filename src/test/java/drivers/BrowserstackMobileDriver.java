package drivers;

import com.codeborne.selenide.WebDriverProvider;
import configs.mobile.Browserstack;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability
                ("browserstack.appium_version", "1.22.0");
        mutableCapabilities.setCapability
                ("browserstack.user", Browserstack.browserstackConfig.user());
        mutableCapabilities.setCapability
                ("browserstack.key", Browserstack.browserstackConfig.key());
        mutableCapabilities.setCapability
                ("app", Browserstack.browserstackConfig.app());
        mutableCapabilities.setCapability
                ("device", Browserstack.browserstackConfig.device());
        mutableCapabilities.setCapability
                ("os_version", Browserstack.browserstackConfig.osVersion());
        mutableCapabilities.setCapability
                ("project", "Ozon");
        mutableCapabilities.setCapability
                ("build", "browserstack-build-1");
        mutableCapabilities.setCapability
                ("name", "Mobile Tests Run");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
