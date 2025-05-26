package pages.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.interfaces.HamburgerMenuPage;
import pages.utils.UtilsMethods;

import java.time.Duration;
import java.util.List;

public class AndroidHamburgerMenuPage extends UtilsMethods implements HamburgerMenuPage {
    private AndroidDriver driver;

    public AndroidHamburgerMenuPage (AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
    private WebElement hamburgerMenu;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"#liveNavListTab\")")
    private WebElement liveIcon;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Football\"])[1]")
    private WebElement sportFootball;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='liveNavList']/android.view.View[@content-desc]")
    private List<WebElement> numberOfEvents;

    /**
     * Iterates through a list of sports with event counts and
     * prints out only those sports that have more than 10 events.
     */
    public void sportWithMoreThan10Events () {
        for (WebElement element : numberOfEvents) {
            String fullText = element.getTagName();
            if (fullText != null || !fullText.trim().isEmpty()) {
                int lastSpace = fullText.lastIndexOf(" ");
                String[] parts = new String[2];
                parts[0] = fullText.substring(0, lastSpace);
                parts[1] = fullText.substring(lastSpace + 1);
                     String sportName = parts[0];
                    int count = Integer.parseInt(parts[1]);
                    if (count > 10) {
                        System.out.println(String.format("%s has total of %d events", sportName, count));
                }
            } else {
                System.out.println("Invalid text: " + fullText);
            }
        }
    }

    /**
     * Attempts to select (click) the hamburger menu icon if it is displayed.
     */
    @Override
    public void selectHamburgerMenu () {
        if (hamburgerMenu.isDisplayed()) {
            hamburgerMenu.click();
            System.out.println("The hamburger menu is selected!");
        } else {
            System.out.println("The hamburger menu is missing!");
        }
    }

    /**
     * Clicks on the Live icon if it is displayed.
     */
    @Override
    public void selectLiveIcon () {
        if (liveIcon.isDisplayed()) {
            liveIcon.click();
            System.out.println("The Live icon is selected!");
        } else {
            System.out.println("The Live icon is missing!");
        }
    }

    /**
     * Selects the Football option if it is displayed on the screen.
     */
    @Override
    public void selectFootball () {
        if (sportFootball.isDisplayed()) {
            sportFootball.click();
            System.out.println("The Sport Football is selected!");
        } else {
            System.out.println("The Football is  is missing or not visible!");
        }
    }
}