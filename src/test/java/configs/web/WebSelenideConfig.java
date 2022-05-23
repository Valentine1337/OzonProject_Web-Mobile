package configs.web;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:webSelenide.properties"
})
public interface WebSelenideConfig extends Config {
    @Key("stand.url")
    String standUrl();

    @Key("browser.name")
    @DefaultValue("chrome")
    String browserName();

    @Key("browser.version")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("browser.size")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browser.remote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("selenoid.user")
    boolean selenoidUser();

    @Key("selenoid.password")
    boolean selenoidPassword();
}
