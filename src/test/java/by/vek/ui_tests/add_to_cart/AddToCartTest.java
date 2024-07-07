package by.vek.ui_tests.add_to_cart;

import by.vek.enums.Product;
import by.vek.pages.CartPage;
import by.vek.pages.SearchPage;
import by.vek.pages.StartPage;
import by.vek.ui_tests.BaseTest;
import by.vek.utils.Waiters;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddToCartTest extends BaseTest {

    @Test
    public void verifyAddProductToCart() {
        StartPage startPage = new StartPage();
        startPage.openURL();
        SearchPage searchPage = startPage.searchByName(Product.SMARTPHONE.getProductName());
        String productNameOnSearchPage = searchPage.getProductsName().get(0);
        searchPage.addProductToCart(0);
        CartPage cartPage = searchPage.clickCartBtn();
        String productNameOnCartPage = cartPage.getProductTitleInCart(0);
        Assert.assertEquals(productNameOnCartPage, productNameOnSearchPage);
    }

    @Test
    public void verifyAddAllProductToCart() {
        StartPage startPage = new StartPage();
        startPage.openURL();
        SearchPage searchPage = startPage.searchByName(Product.SMARTPHONE.getProductName());
        List<String> productsNameOnSearchPage = searchPage.getProductsName();
        searchPage.addAllProductToCart();
        CartPage cartPage = searchPage.clickCartBtn();
        List<String> productsNameOnCartPage = cartPage.getProductsNameInCart();
        Assert.assertEquals(productsNameOnCartPage, productsNameOnSearchPage);
    }
}

