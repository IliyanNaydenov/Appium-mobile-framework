package pages.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.interfaces.HomePage;

import java.time.Duration;

public class IOSHomePage implements HomePage {
    private IOSDriver driver;
    @iOSXCUITFindBy(xpath="//[@class='...']")
    private WebElement appIcon;
    @iOSXCUITFindBy(xpath="//[@class='...']")
    private WebElement homeIcon;

    public IOSHomePage (IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @Override
    public void openApp () {
    }

    @Override
    public boolean isLoadedSuccessFullyHomePage () {
        return false;
    }
}