package by.vek.pages;

import org.openqa.selenium.WebDriver;

class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
