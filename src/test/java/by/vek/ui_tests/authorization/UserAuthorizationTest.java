package by.vek.ui_tests.authorization;

import by.vek.enums.UserTest;
import by.vek.pages.LoginPage;
import by.vek.pages.StartPage;
import by.vek.service.LoginService;
import by.vek.ui_tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserAuthorizationTest extends BaseTest {


    @Test
    public void authorizationUser() {
        StartPage startPage = new StartPage();
        startPage.openURL();
        startPage.openAccountWindow();
        LoginPage loginPage = startPage.clickByLoginBtn();
        loginPage.typeEmailByInputField(UserTest.EMAIL.getDataUser());
        loginPage.typePasswordByInputField(UserTest.PASSWORD.getDataUser());
        startPage = loginPage.clickBySubmitBtn();
        String emailUser = startPage.getUserEmail();
        Assert.assertEquals(emailUser, UserTest.EMAIL.getDataUser(),
                "Account name is not equal to email");
    }


    @Test(dataProvider = "emptyData", dataProviderClass = DataProviderLogin.class)
    public void authorizationUserEmptyData(String email, String password, String emailMessage, String passwordMessage) {
        LoginPage loginPage = LoginService.login(email, password);
        Assert.assertTrue(loginPage.isEmailErrorMessageEqual(emailMessage),
                "Error message email is not equal to expected");
        Assert.assertTrue(loginPage.isPasswordErrorMessageEqual(passwordMessage),
                "Error message password is not equal to expected");
    }


    @Test(dataProvider = "emptyPassword", dataProviderClass = DataProviderLogin.class)
    public void authorizationUserEmptyPassword(String email, String password, String passwordMessage) {
        LoginPage loginPage = LoginService.login(email, password);
        Assert.assertTrue(loginPage.isPasswordErrorMessageEqual(passwordMessage),
                "Error message password is not equal to expected");
        Assert.assertFalse(loginPage.isPresentWebElementEmailErrorMessage(),
                "Error message email is present");
    }


    @Test(dataProvider = "emptyEmail", dataProviderClass = DataProviderLogin.class)
    public void authorizationUserEmptyEmail(String email, String password, String emailMessage) {
        LoginPage loginPage = LoginService.login(email, password);
        Assert.assertTrue(loginPage.isEmailErrorMessageEqual(emailMessage),
                "Error message email is not equal to expected");
        Assert.assertFalse(loginPage.isPresentWebElementPasswordErrorMessage(),
                "Error message password is present");
    }


    @Test(dataProvider = "notRegisteredEmail", dataProviderClass = DataProviderLogin.class)
    public void authorizationUserEmailIsNotRegistered(String email, String password, String emailMessage) {
        LoginPage loginPage = LoginService.login(email, password);
        Assert.assertTrue(loginPage.isEmailErrorMessageEqual(emailMessage),
                "Error message email is not equal to expected");
        Assert.assertFalse(loginPage.isPresentWebElementPasswordErrorMessage(),
                "Error message password is present");
    }


}
