package by.vek.pages;

import by.vek.utils.Waiters;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.DriverManager;

public class StartPage extends BasePage {

    @FindBy(xpath = "//span[text()='Аккаунт']")
    private WebElement accountBtn;
    @FindBy(xpath = "//div[text()='Принять']")
    private WebElement acceptCookie;
    @FindBy(xpath = "//button[@data-testid='loginButton']")
    private WebElement loginBtn;
    @FindBy(xpath = "//button[@name='button']")
    private WebElement closeBtnSaleCode;


    private final String url = "https://www.21vek.by/";

    public StartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openURL()  {
        driver.get(url);
//        Cookie setCookie = new Cookie("mindboxDeviceUUID", "f1603448-4e4d-4ea3-8aab-27b4fb082c59");
//        driver.manage().addCookie(setCookie);
//        driver.navigate().refresh();
        try {
            Waiters.waitElementIsVisible(driver, acceptCookie);
            if (acceptCookie.isDisplayed()) {
                acceptCookie.click();
            }
        } catch (NoSuchElementException | TimeoutException e){
            System.out.println("Кнопки кук нет");
        }

        try {
            Waiters.waitElementIsVisible(driver, closeBtnSaleCode);
            if (closeBtnSaleCode.isDisplayed()) {
                closeBtnSaleCode.click();
            }
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Кнопки закрыть код скидки нету");
        }


    }

//    public void openURL() {
//        driver.get(url);
//        Cookie cookie = new Cookie("JSESSIONID", "7459007A75979B766442FB3A7A13ED46");
//
//        driver.manage().addCookie(cookie);
//
//        driver.navigate().refresh();
//
//    }

    public void openAccountWindow() {
        Waiters.waitElementIsClickable(driver, accountBtn);
        accountBtn.click();
    }

    public LoginPage clickByLoginBtn() {
        Waiters.waitElementIsClickable(driver, loginBtn);
        loginBtn.click();
        return new LoginPage(driver);
    }
}
