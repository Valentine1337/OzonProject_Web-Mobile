package configs.mobile;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:configs/browserstack.properties"
})
public interface BrowserstackConfig extends Config {
    @Key("user.name")
    String user();

    @Key("user.key")
    String key();

    @Key("app.name")
    String app();

    @Key("device")
    @DefaultValue("Google Pixel 3")
    String device();

    @Key("os.version")
    @DefaultValue("9.0")
    String osVersion();
}
