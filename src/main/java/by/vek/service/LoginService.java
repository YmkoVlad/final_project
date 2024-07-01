package by.vek.service;

import by.vek.pages.LoginPage;
import by.vek.pages.StartPage;
import by.vek.utils.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class LoginService {

    public LoginService() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public static LoginPage login(String email, String password) {
        StartPage startPage = new StartPage();
        startPage.openURL();
        startPage.openAccountWindow();
        LoginPage loginPage = startPage.clickByLoginBtn();
        loginPage.typeEmailByInputField(email);
        loginPage.typePasswordByInputField(password);
        loginPage.clickBySubmitBtn();
        return new LoginPage();
    }


}
