package configs.web;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:configs/web.properties"})
public interface WebConfig extends Config {
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
    String selenoidUser();

    @Key("selenoid.password")
    String selenoidPassword();
}
