package pages.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.interfaces.FootballPage;
import pages.utils.UtilsMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AndroidFootballPage extends UtilsMethods implements FootballPage {
    private AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.view.View[matches(@resource-id, '^\\d+$')] and @bounds='[10,488][1060,2203]'")
    private List<WebElement> eventBlocks;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"appComponents\")")
    private WebElement footballEventsContainer;

    public AndroidFootballPage (AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    /**
     * Extracts and returns a list of visible "Match Result" events from the UI elements.
     *
     * @return a list of maps, each representing a visible "Match Result" event with its data
     */
    @Override
    public List<Map<String, Object>> extractVisibleMatchResultEvents () {
        waitElementToBeDisplayed(footballEventsContainer, 15);
        List<Map<String, Object>> eventsList = new ArrayList<>();
        for (WebElement event : eventBlocks) {
            boolean hasMatchResult;
            try {
                hasMatchResult = event.findElement(By.xpath("//*[@text='Match Result']")).isDisplayed();
            } catch (NoSuchElementException e) {
                hasMatchResult = false;
            }
            if (hasMatchResult) {
                System.out.println("We found one match!");

                List<WebElement> teams = event.findElements(By.xpath("//android.view.View[1]//android.widget.TextView[@text]"));
                //Teams
                String homeTeam = teams.get(0).getText();
                String awayTeam = teams.get(1).getText();
                //Scores
                String homeScore = teams.get(6).getText();
                String awayScore = teams.get(7).getText();
                //Odds
                List<Double> odds = new ArrayList<>();
                for (int i = 9; i <= 11; i++) {
                    String text = teams.get(i).getText();
                    if (text != null && !text.trim().isEmpty()) {
                        odds.add(Double.valueOf(text));
                    }
                }
                Map<String, Object> eventData = new HashMap<>();
                eventData.put("Home Team Name", homeTeam);
                eventData.put("Away Team Name", awayTeam);
                eventData.put("Home Team Score", homeScore);
                eventData.put("Away Team Score", awayScore);
                eventData.put("Market Name", "Match Result");
                eventData.put("Odds", odds);
                eventsList.add(eventData);
            }
        }
        for (Map<String, Object> event : eventsList) {
            System.out.println(event);
        }
        return eventsList;
    }

    /**
     * Prints all events that have at least one odd value within the range [1.50, 2.50].
     *
     * @param events a list of event maps, where each map contains a key "Odds" mapped to
     *               a list of string representations of numeric odds.
     */
    @Override
    public void printEventsWithOddsInRange (List<Map<String, Object>> events) {
        for (Map<String, Object> event : events) {
            List<String> odds = (List<String>) event.get("Odds");
            for (String oddStr : odds) {
                double odd = Double.parseDouble(oddStr);
                if (odd >= 1.50 && odd <= 2.50) {
                    System.out.println(event);
                    break;
                }
            }
        }
    }

    /**
     * Sorts the given list of events in descending order based on the sum of their "Odds" values,
     * then prints each event along with the total sum of its odds.
     *
     * @param events a list of event maps, where each map contains a key "Odds" mapped to
     *               a list of string representations of numeric odds.
     */
    @Override
    public void printEventsSortedBySumOfOdds (List<Map<String, Object>> events) {
        events.sort((e1, e2) -> {
            double sum1 = 0;
            double sum2 = 0;
            for (String odd : (List<String>) e1.get("Odds")) {
                sum1 += Double.parseDouble(odd);
            }
            for (String odd : (List<String>) e2.get("Odds")) {
                sum2 += Double.parseDouble(odd);
            }

            return Double.compare(sum2, sum1);
        });
        for (Map<String, Object> event : events) {
            double total = 0;
            List<String> odds = (List<String>) event.get("Odds");
            for (String odd : odds) {
                total += Double.parseDouble(odd);
            }
            System.out.println(event + " with total Sum: " + total);
        }
    }

    /**
     * Prints all events where the home team score is equal to the away team score,
     * indicating a draw.
     *
     * @param events a list of maps representing events, where each map
     *               contains the keys "Home Team Score" and "Away Team Score"
     *               with their values as Strings.
     */
    @Override
    public void printDrawScoreEvents (List<Map<String, Object>> events) {

        for (Map<String, Object> event : events) {
            String homeScore = (String) event.get("Home Team Score");
            String awayScore = (String) event.get("Away Team Score");

            if (homeScore.equals(awayScore)) {
                System.out.println(event + "-" + homeScore + ":" + awayScore + "-");
            }
        }
    }
}