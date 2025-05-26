package factory;

import io.appium.java_client.AppiumDriver;
import pages.android.AndroidFootballPage;
import pages.android.AndroidHamburgerMenuPage;
import pages.android.AndroidHomePage;
import pages.interfaces.FootballPage;
import pages.interfaces.HamburgerMenuPage;
import pages.interfaces.HomePage;
import pages.ios.IOSFootballPage;
import pages.ios.IOSHamburgerMenuPage;
import pages.ios.IOSHomePage;

public class PageFactoryManager {

    public static HomePage getLoginPage(AppiumDriver driver, String platform) {
        if (platform.equalsIgnoreCase("android")) {
            return new AndroidHomePage((io.appium.java_client.android.AndroidDriver) driver);
        } else if (platform.equalsIgnoreCase("ios")) {
            return new IOSHomePage((io.appium.java_client.ios.IOSDriver) driver);
        } else {
            throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
    }

    public static HamburgerMenuPage getHamburgerMenuPage(AppiumDriver driver, String platform) {
        if (platform.equalsIgnoreCase("android")) {
            return new AndroidHamburgerMenuPage((io.appium.java_client.android.AndroidDriver) driver);
        } else if (platform.equalsIgnoreCase("ios")) {
            return new IOSHamburgerMenuPage((io.appium.java_client.ios.IOSDriver) driver);
        } else {
            throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
    }

    public static FootballPage getFootballPage(AppiumDriver driver, String platform) {
        if (platform.equalsIgnoreCase("android")) {
            return new AndroidFootballPage((io.appium.java_client.android.AndroidDriver) driver);
        } else if (platform.equalsIgnoreCase("ios")) {
            return new IOSFootballPage((io.appium.java_client.ios.IOSDriver) driver);
        } else {
            throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
    }
}
