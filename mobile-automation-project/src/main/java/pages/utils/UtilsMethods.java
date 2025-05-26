package pages.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class UtilsMethods {

    WebDriver driver;

    public UtilsMethods (WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Waits until the given WebElement is visible on the screen.
     *
     * @param element The WebElement to wait for.
     * @param timeoutInSeconds waiting time.
     */
    public void waitElementToBeDisplayed(WebElement element,long timeoutInSeconds ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
