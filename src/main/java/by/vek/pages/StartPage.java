package by.vek.pages;

import by.vek.utils.DriverManager;
import by.vek.utils.Waiters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class StartPage extends BasePage {

    @FindBy(xpath = "//span[text()='Аккаунт']")
    private WebElement accountBtn;
    @FindBy(xpath = "//div[text()='Принять']")
    private WebElement acceptCookie;
    @FindBy(xpath = "//button[@data-testid='loginButton']")
    private WebElement loginBtn;
    @FindBy(xpath = "//button[@name='button']")
    private WebElement closeBtnSaleCode;
    @FindBy(xpath = "//input[@id='catalogSearch']")
    private WebElement fieldSearch;

    private final String url = "https://www.21vek.by/";

    private static final Logger LOGGER = LogManager.getLogger(StartPage.class);


    public StartPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    public void openURL()  {
        DriverManager.getDriver().get(url);
        Waiters.openURL(url);
        Waiters.waitElementIsVisible(fieldSearch);

        try {
            Waiters.waitElementIsVisible(acceptCookie);
            if (acceptCookie.isDisplayed()) {
                acceptCookie.click();
            }
        } catch (NoSuchElementException | TimeoutException e){
            LOGGER.info("Cookie button is missing");
        }

        try {
            Waiters.waitElementIsVisible(closeBtnSaleCode);
            if (closeBtnSaleCode.isDisplayed()) {
                closeBtnSaleCode.click();
            }
        } catch (NoSuchElementException | TimeoutException e) {
            LOGGER.info("Close button discount code is missing");
        }
    }

    public void openAccountWindow() {
        Waiters.waitElementIsClickable(accountBtn);
        accountBtn.click();
    }

    public LoginPage clickByLoginBtn() {
        Waiters.waitElementIsClickable(loginBtn);
        loginBtn.click();
        return new LoginPage();
    }

    public SearchPage searchByName(String name) {
        Waiters.waitElementIsClickable(fieldSearch);
//        fieldSearch.click();
        fieldSearch.sendKeys(name, Keys.ENTER);
        return new SearchPage();
    }
}
