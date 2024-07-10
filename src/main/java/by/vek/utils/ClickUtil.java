package by.vek.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class ClickUtil {

    private static final Logger LOGGER = LogManager.getLogger(ClickUtil.class);

    public static void closeCookieWindow (WebElement element) {
        try {
            Waiters.waitElementIsVisible(element);
            if (element.isDisplayed()) {
                element.click();
            }
        } catch (NoSuchElementException | TimeoutException e){
            LOGGER.info("Cookie button is missing");
        }
    }


    public static void closeDiscountWindow (WebElement element) {
        try {
            Waiters.waitElementIsVisible(element);
            if (element.isDisplayed()) {
                element.click();
            }
        } catch (NoSuchElementException | TimeoutException e) {
            LOGGER.info("Close button discount code is missing");
        }
    }
}
