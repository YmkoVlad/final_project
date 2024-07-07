package by.vek.service;


import by.vek.pages.SearchPage;
import by.vek.utils.DriverManager;
import by.vek.utils.Waiters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloseDiscountWindow {

    @FindBy(xpath = "//button[@name='button']")
    private WebElement closeBtnSaleCode;

    private static final Logger LOGGER = LogManager.getLogger(CloseDiscountWindow.class);

    public CloseDiscountWindow() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public  void closeWindow() {
        try {
            Waiters.waitElementIsVisible(closeBtnSaleCode);
            if (closeBtnSaleCode.isDisplayed()) {
                closeBtnSaleCode.click();
            }
        } catch (NoSuchElementException | TimeoutException e) {
            LOGGER.info("Close button discount code is missing");
        }
    }
}
