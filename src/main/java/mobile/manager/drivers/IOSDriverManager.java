package mobile.manager.drivers;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import mobile.manager.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

import static mobile.manager.server.AppiumServerManager.*;

public class IOSDriverManager {

    private static final ThreadLocal<IOSDriver> DRIVER = new ThreadLocal<>();
    private static final Logger LOG = LogManager.getLogger("DriverManager.class");

    public static IOSDriver getDriver() {
        return IOSDriverManager.DRIVER.get();
    }

    private static void setDriver(IOSDriver driver) {
        IOSDriverManager.DRIVER.set(driver);
    }


    private static XCUITestOptions xcuiTestOptions() {
        return new XCUITestOptions()
                .setDeviceName("iPhone 14 Pro Max")
                .setAutomationName(AutomationName.IOS_XCUI_TEST)
                .setNewCommandTimeout(Duration.ofSeconds(60))
                .setPlatformVersion("16.2")
                .setApp(Constants.IPA_APP_PATH)
                .setNoReset(false);
    }

    public static void quitSession() {
        if (null != DRIVER.get()) {
            LOG.info("Closing the driver...");
            getDriver().quit();
            DRIVER.remove();
            stopServer();
        }
    }

    public static void createIOSDriver() {
        startServer("ios");
        setDriver(new IOSDriver(getService().getUrl(), xcuiTestOptions()));
        setupDriverTimeouts();
    }

    private static void setupDriverTimeouts() {
        getDriver().manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(5));
    }
}
