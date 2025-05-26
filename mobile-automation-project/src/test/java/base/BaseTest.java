package base;

import factory.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected AppiumDriver driver;
    protected String platform;

    @BeforeMethod
    @Parameters("platform")
    public void setUp(String platform) {
        this.platform = platform;
        driver = DriverFactory.createDriver(platform);
    }

    @AfterMethod
    public void tearDown() {
        ((InteractsWithApps) driver).terminateApp("app.sport.empire");
        if (driver != null) {
            driver.quit();
        }
    }
}
