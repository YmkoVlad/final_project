package by.vek.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
            return new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.firefox.driver", "C:/ChromeDriver/geckodriver.exe");
            return new FirefoxDriver();
        }
        return null;
    }
}
