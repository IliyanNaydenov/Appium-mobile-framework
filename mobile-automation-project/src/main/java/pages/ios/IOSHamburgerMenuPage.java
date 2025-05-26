package pages.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.interfaces.HamburgerMenuPage;

import java.time.Duration;

public class IOSHamburgerMenuPage implements HamburgerMenuPage {

    private IOSDriver driver;
    @iOSXCUITFindBy(xpath="//[@class='...']")
    private WebElement hamburgerMenu;

    @iOSXCUITFindBy(xpath="//[@class='...']")
    private WebElement liveIcon;

    @iOSXCUITFindBy(xpath="//[@class='...']")
    private WebElement sportFootball;

    public IOSHamburgerMenuPage (IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
    @Override
    public void selectHamburgerMenu () {

    }

    @Override
    public void selectLiveIcon () {

    }

    @Override
    public void selectFootball () {

    }

    @Override
    public void sportWithMoreThan10Events () {

    }
}
