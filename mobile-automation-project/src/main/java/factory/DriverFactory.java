package factory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.URL;
import java.time.Duration;
public class DriverFactory {

    public static AppiumDriver createDriver(String platform) {
        try {
            if (platform.equalsIgnoreCase("android")) {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android");
                options.setAutomationName("UiAutomator2");
                options.setDeviceName("emulator-5554");

                AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                return driver;

            } else if (platform.equalsIgnoreCase("ios")) {
                XCUITestOptions options = new XCUITestOptions();
                options.setPlatformName("iOS");
                options.setDeviceName("iPhone 14");
                options.setAutomationName("XCUITest");

                IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                return driver;
            } else {
                throw new IllegalArgumentException("Unsupported platform: " + platform);
            }

        } catch (Exception e) {
            throw new RuntimeException("Driver creation failed: " + e.getMessage(), e);
        }
    }
}