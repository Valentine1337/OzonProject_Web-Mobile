package configs.mobile;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:configs/emulator.properties"
})
public interface EmulatorConfig extends Config {
    @Key("platform.name")
    String platformName();

    @Key("language")
    String language();

    @Key("device.name")
    String deviceName();

    @Key("platform.version")
    String platformVersion();

    @Key("app.package")
    String appPackage();

    @Key("app.activity")
    String appActivity();
}
