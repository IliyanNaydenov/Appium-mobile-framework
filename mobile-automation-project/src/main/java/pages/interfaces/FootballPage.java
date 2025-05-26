package pages.interfaces;

import java.util.List;
import java.util.Map;

public interface FootballPage {
    List<Map<String, Object>> extractVisibleMatchResultEvents ();

    void printEventsWithOddsInRange (List<Map<String, Object>>events);

    void printEventsSortedBySumOfOdds (List<Map<String, Object>>events);

    void printDrawScoreEvents (List<Map<String, Object>> events);
}
