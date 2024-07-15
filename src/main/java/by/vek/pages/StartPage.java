package by.vek.pages;

import by.vek.utils.ClickUtil;
import by.vek.utils.DriverManager;
import by.vek.utils.Waiters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;


public class StartPage {

    @FindBy(xpath = "//span[text()='Аккаунт']")
    private WebElement accountBtn;
    @FindBy(xpath = "//div[text()='Принять']")
    private WebElement acceptBtnCookie;
    @FindBy(xpath = "//button[@data-testid='loginButton']")
    private WebElement loginBtn;
    @FindBy(xpath = "//button[@name='button']")
    private WebElement closeBtnSaleCode;
    @FindBy(xpath = "//input[@id='catalogSearch']")
    private WebElement fieldSearch;
    @FindBy(xpath = "//span[@class='userToolsSubtitle']")
    private WebElement fieldUserEmail;


    private final String url = "https://www.21vek.by/";

    private static final Logger LOGGER = LogManager.getLogger(StartPage.class);


    public StartPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    public void openURL() {
        DriverManager.getDriver().get(url);
        Waiters.openURL(url);
        Waiters.waitElementIsVisible(fieldSearch);
        ClickUtil.closeCookieWindow(acceptBtnCookie);
        ClickUtil.closeDiscountWindow(closeBtnSaleCode);
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
        fieldSearch.sendKeys(name, Keys.ENTER);
        return new SearchPage();
    }

    public String getUserEmail() {
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        Waiters.waitElementIsClickable(accountBtn);
        try {
            accountBtn.click();
        } catch (StaleElementReferenceException e) {
            Waiters.waitElementIsClickable(accountBtn);
            accountBtn.click();
        }
        Waiters.waitElementIsVisible(fieldUserEmail);
        return fieldUserEmail.getText();
    }
}
