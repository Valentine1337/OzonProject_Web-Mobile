package drivers;

public class DriverSwitcher {
    public static String getDriver(String driverSwitch) {
        switch (driverSwitch) {
            case "browserstack":
                return BrowserstackMobileDriver.class.getName();
            case "emulator":
                return EmulatorMobileDriver.class.getName();
            default:
                throw new RuntimeException("Select device: browserstack / emulator");
        }
    }
}
