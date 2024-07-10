package by.vek.ui_tests.authorization;

import by.vek.pages.LoginPage;
import by.vek.pages.StartPage;
import by.vek.service.LoginService;
import by.vek.ui_tests.BaseTest;
import by.vek.utils.Waiters;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserAuthorizationTest extends BaseTest {


    @Test
    public void authorizationUser() throws InterruptedException {
        StartPage startPage = new StartPage();
        startPage.openURL();
        startPage.openAccountWindow();
        LoginPage loginPage = startPage.clickByLoginBtn();
        loginPage.typeEmailByInputField("Kukharevich.vlad@gmail.com");
        loginPage.typePasswordByInputField("19ae43ba");
        startPage = loginPage.clickBySubmitBtn();
        String emailUser = startPage.getUserEmail();
        Assert.assertEquals(emailUser, "kukharevich.vlad@gmail.com");
    }


    @Test(dataProvider = "emptyData", dataProviderClass = DataProviderLogin.class)
    public void authorizationUserEmptyData(String email, String password, String emailMessage, String passwordMessage) throws InterruptedException {
        LoginPage loginPage = LoginService.login(email, password);
        Assert.assertTrue(loginPage.isEmailErrorMessageEqual(emailMessage));
        Assert.assertTrue(loginPage.isPasswordErrorMessageEqual(passwordMessage));
    }


    @Test(dataProvider = "emptyPassword", dataProviderClass = DataProviderLogin.class)
    public void authorizationUserEmptyPassword(String email, String password, String passwordMessage) {
        LoginPage loginPage = LoginService.login(email, password);
        Assert.assertTrue(loginPage.isPasswordErrorMessageEqual(passwordMessage));
        Assert.assertFalse(loginPage.isPresentWebElementEmailErrorMessage());
    }


    @Test(dataProvider = "emptyEmail", dataProviderClass = DataProviderLogin.class)
    public void authorizationUserEmptyEmail(String email, String password, String emailMessage) {
        LoginPage loginPage = LoginService.login(email, password);
        Assert.assertTrue(loginPage.isEmailErrorMessageEqual(emailMessage));
        Assert.assertFalse(loginPage.isPresentWebElementPasswordErrorMessage());
    }


    @Test(dataProvider = "notRegisteredEmail", dataProviderClass = DataProviderLogin.class)
    public void authorizationUserEmailIsNotRegistered(String email, String password, String emailMessage) throws InterruptedException {
        LoginPage loginPage = LoginService.login(email, password);
        Assert.assertTrue(loginPage.isEmailErrorMessageEqual(emailMessage));
        Assert.assertFalse(loginPage.isPresentWebElementPasswordErrorMessage());
    }


}
