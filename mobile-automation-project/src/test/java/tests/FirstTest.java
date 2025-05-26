package tests;

import base.BaseTest;
import com.google.common.collect.ImmutableMap;
import factory.PageFactoryManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.interfaces.FootballPage;
import pages.interfaces.HamburgerMenuPage;
import pages.interfaces.HomePage;

import java.util.List;
import java.util.Map;

public class FirstTest extends BaseTest {
    HamburgerMenuPage hamburgerMenuPage;
    HomePage homePage;
    FootballPage footballPage;

    @Test
    public void verifyEventsInfo () {
        homePage = PageFactoryManager.getLoginPage(driver, platform);
        hamburgerMenuPage = PageFactoryManager.getHamburgerMenuPage(driver, platform);
        footballPage = PageFactoryManager.getFootballPage(driver, platform);
        //Open App
        //homePage.openApp();
        (driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","app.sport.empire/app.sport.empire.MainActivity"));
        //Verify that the app is loaded successfully
        Assert.assertTrue(homePage.isLoadedSuccessFullyHomePage(), "The page is not loaded");
        //Click on the top left-side menu (hamburger menu icon).
        hamburgerMenuPage.selectHamburgerMenu();
        //Select Live icon from the navigation menu
        hamburgerMenuPage.selectLiveIcon();
        //Print all the sports which have more than 10 events
        hamburgerMenuPage.sportWithMoreThan10Events();
        //Select Football
        hamburgerMenuPage.selectFootball();
        //Extract the following data from all fully visible events on the page,
        List<Map<String, Object>> eventsList = footballPage.extractVisibleMatchResultEvents();
        //Filter all events by odd range
        //footballPage.printEventsWithOddsInRange(eventsList);
        //Sort events by sum of odds
       // footballPage.printEventsSortedBySumOfOdds(eventsList);
        //Filter events by score
       // footballPage.printDrawScoreEvents(eventsList);

    }
}