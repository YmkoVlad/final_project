package by.vek.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class ElementActionListener implements WebDriverListener {

    @Override
    public void afterGet(WebDriver driver, String url) {
        System.out.println("Open URL: " + url);
    }

    @Override
    public void afterClick(WebElement element) {
        System.out.println("Click at Element " + element);
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        System.out.println("GetText from the element " + element);
    }

    @Override
    public void afterQuit(WebDriver driver) {
        System.out.println("Test execution completed");
    }
}
