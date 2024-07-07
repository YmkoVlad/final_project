package by.vek.pages;

import by.vek.utils.DriverManager;
import by.vek.utils.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//a[@class='BasketItem_title__MzCQ9']")
    private List<WebElement> productTitleInCart;

    public CartPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public String getProductTitleInCart(int index) {
        Waiters.waitElementIsVisibleAll(productTitleInCart);
        return productTitleInCart.get(index).getText();
    }

    public List<String> getProductsNameInCart() {
        Waiters.waitElementIsVisibleAll(productTitleInCart);
        return productTitleInCart.stream().map(k -> k.getText()).toList();
    }
}
