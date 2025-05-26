package pages.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pages.interfaces.FootballPage;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class IOSFootballPage implements FootballPage {
    private IOSDriver driver;


    public IOSFootballPage (IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @Override
    public List<Map<String, Object>> extractVisibleMatchResultEvents () {
        return List.of();
    }

    @Override
    public void printEventsWithOddsInRange (List<Map<String, Object>> events) {

    }

    @Override
    public void printEventsSortedBySumOfOdds (List<Map<String, Object>> events) {

    }

    @Override
    public void printDrawScoreEvents (List<Map<String, Object>> events) {

    }
}
