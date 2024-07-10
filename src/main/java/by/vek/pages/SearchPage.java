package by.vek.pages;


import by.vek.utils.ClickUtil;
import by.vek.utils.DriverManager;
import by.vek.utils.Waiters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//span[@class='result__name']")
    private List<WebElement> nameOfProducts;
    @FindBy(xpath = "//a[@class='headerCartBox']")
    private WebElement cartButton;
    @FindBy(xpath = "//dl //dt[@class='result__root']")
    private List<WebElement> resultRoot;
    @FindBy(xpath = "//dl //dd[@class='result__desc ']")
    private List<WebElement> resultDesc;
    @FindBy(xpath = "//*[text() = 'В корзину']")
    private List<WebElement> addToCartBtn;
    @FindBy(xpath = "//button[@name='button']")
    private WebElement closeBtnSaleCode;

    private static final Logger LOGGER = LogManager.getLogger(SearchPage.class);

    public SearchPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public List<String> getProductsName() {
        Waiters.waitElementIsVisibleAll(nameOfProducts);
        return nameOfProducts.stream().map(k -> k.getText()).toList();
    }

    public CartPage clickCartBtn() {
        Waiters.waitElementIsClickable(cartButton);
        cartButton.click();
        return new CartPage();
    }

    public void addProductToCart(int index) {
        ClickUtil.closeDiscountWindow(closeBtnSaleCode);
        Waiters.waitElementIsVisibleAll(addToCartBtn);
        addToCartBtn.get(index).click();
    }

    public void addAllProductToCart() {
        ClickUtil.closeDiscountWindow(closeBtnSaleCode);
        Waiters.waitElementIsVisibleAll(addToCartBtn);
        for (WebElement element : addToCartBtn) {
            Waiters.waitElementIsClickable(element);
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", element);
        }
    }

}
