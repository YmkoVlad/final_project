package by.vek.pages;


import by.vek.service.CloseDiscountWindow;
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
        CloseDiscountWindow closeDiscountWindow = new CloseDiscountWindow();
        closeDiscountWindow.closeWindow();
//        resultDesc.get(index).findElement(By.xpath(".//button")).click();
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();",
                resultDesc.get(index).findElement(By.xpath("//button")));
    }

}
