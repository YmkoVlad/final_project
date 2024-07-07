package by.vek.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waiters {

    public static WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement waitElementIsClickable(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public static List<WebElement> waitElementIsVisibleAll(List<WebElement> elements) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements;
    }
}
