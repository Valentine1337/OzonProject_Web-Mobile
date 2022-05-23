package configs.mobile;

import org.aeonbits.owner.ConfigFactory;

public class Browserstack {
    public static BrowserstackConfig
            browserstackConfig = ConfigFactory.create(BrowserstackConfig.class);
}
