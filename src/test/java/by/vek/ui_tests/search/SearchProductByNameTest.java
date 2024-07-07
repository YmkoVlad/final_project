package by.vek.ui_tests.search;

import by.vek.enums.Product;
import by.vek.pages.SearchPage;
import by.vek.pages.StartPage;
import by.vek.ui_tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SearchProductByNameTest extends BaseTest {

    @Test
    public void verifyProductByName() {
        StartPage startPage = new StartPage();
        startPage.openURL();
        SearchPage searchPage = startPage.searchByName(Product.DENTALFLOSS.getProductName());
        Assert.assertTrue(searchPage.getProductsName().get(0).toLowerCase()
                .contains(Product.DENTALFLOSS.getProductName().toLowerCase()));
    }

    @Test
    public void verifyAllProductByName() {
        StartPage startPage = new StartPage();
        startPage.openURL();
        SearchPage searchPage = startPage.searchByName(Product.PUMP.getProductName());
        SoftAssert softAssert = new SoftAssert();
        for (String productName: searchPage.getProductsName()) {
           softAssert.assertTrue(productName.toLowerCase().contains(Product.PUMP.getProductName().toLowerCase()));
        }
    }
}
