package by.vek.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class ElementActionListener implements WebDriverListener {

    private static final Logger LOGGER = LogManager.getLogger(MethodsTestListneres.class);

    @Override
    public void afterGet(WebDriver driver, String url) {
        LOGGER.info("Open URL: " + url);
    }

    @Override
    public void afterClick(WebElement element) {
        LOGGER.info("Click at Element " + element);
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        LOGGER.info("GetText from the element " + element);
    }

    @Override
    public void afterQuit(WebDriver driver) {
        LOGGER.info("Test execution completed");
    }
}
