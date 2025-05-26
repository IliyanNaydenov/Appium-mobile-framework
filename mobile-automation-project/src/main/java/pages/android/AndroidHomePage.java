package pages.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.interfaces.HomePage;
import pages.utils.UtilsMethods;

import java.time.Duration;

public class AndroidHomePage extends UtilsMethods implements HomePage {
    private AndroidDriver driver;

    public AndroidHomePage (AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(accessibility = "SportEmpire")
    private WebElement appIcon;

    @AndroidFindBy(xpath = "(//android.widget.Image[@text=\"Carousel item\"])[1]")
    private WebElement carouseItem;

    /**
     * Attempts to open the app by clicking on the app icon if it is displayed.
     */
    @Override
    public void openApp () {
        appIcon.click();
    }

    /**
     * Checks whether the Home page is successfully loaded by waiting for the Home icon to become visible.
     *
     * @return {@code true} if the Home icon is visible (page is loaded), {@code false} otherwise
     */
    @Override
    public boolean isLoadedSuccessFullyHomePage () {
        try {
            waitElementToBeDisplayed(carouseItem,50);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}