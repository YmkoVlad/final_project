package by.vek.ui_tests.Authorization;

import by.vek.pages.LoginPage;
import by.vek.pages.StartPage;
import by.vek.ui_tests.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserAuthorizationTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(UserAuthorizationTest.class);



    @Test
    public void authorizationUser() throws InterruptedException {
        StartPage startPage = new StartPage(driver);
        startPage.openURL();
        startPage.openAccountWindow();
        LoginPage loginPage = startPage.clickByLoginBtn();
        loginPage.typeEmailByInputField("Kukharevich.vlad@gmail.com");
        loginPage.typePasswordByInputField("19ae43ba");
        loginPage.clickBySubmitBtn();
    }

//    @DataProvider(name = "inputLoginAndPassword")
//    public Object[][] getData() {
//        return new Object[][]{
//                {"", "", "Электронная почта не указана", "Пароль не указан"},
//                {"Kukharevich.vlad@gmail.com", "", "", "Пароль не указан"},
//                {"", "password123", "Электронная почта не указана", ""},
//                {"Kukharevich1.vlad@gmail.com", "123фис", "Проверьте электронную почту", ""},
//                {"Kukharevich.vlad@gmail.com", "33211", "", "Неправильный пароль."}
//        };
//    }

//    @Test(dataProvider = "inputLoginAndPassword")
//    public void authorizationUser2(String email, String password, String emailMessage, String passwordMessage ) throws InterruptedException {
//        StartPage startPage = new StartPage(driver);
//        startPage.openURL();
//        startPage.openAccountWindow();
//        LoginPage loginPage = startPage.clickByLoginBtn();
//        loginPage.typeEmailByInputField(email);
//        loginPage.typePasswordByInputField(password);
//        loginPage.clickBySubmitBtn();
//        Assert.assertTrue(loginPage.getErrorMessage(emailMessage, passwordMessage));
//    }


    //    @Test(dataProvider = "emptyData", dataProviderClass = DataProviderLogin.class)
//    public void authorizationUserEmptyData(String email, String password, String emailMessage, String passwordMessage) throws InterruptedException {
//        StartPage startPage = new StartPage(driver);
//        startPage.openURL();
//        startPage.openAccountWindow();
//        LoginPage loginPage = startPage.clickByLoginBtn();
//        loginPage.typeEmailByInputField(email);
//        loginPage.typePasswordByInputField(password);
//        loginPage.clickBySubmitBtn();
//        Assert.assertTrue(loginPage.isEmailErrorMessageEqual(emailMessage)
//                & loginPage.isPasswordErrorMessageEqual(passwordMessage));
//    }
    private LoginPage test1(String email, String password) {
        StartPage startPage = new StartPage(driver);
        startPage.openURL();
        startPage.openAccountWindow();
        LoginPage loginPage = startPage.clickByLoginBtn();
        loginPage.typeEmailByInputField(email);
        loginPage.typePasswordByInputField(password);
        loginPage.clickBySubmitBtn();
        return new LoginPage(driver);
    }

    private StartPage test2(String email, String password) {
        StartPage startPage = new StartPage(driver);
        startPage.openURL();
        startPage.openAccountWindow();
        LoginPage loginPage = startPage.clickByLoginBtn();
        loginPage.typeEmailByInputField(email);
        loginPage.typePasswordByInputField(password);
        return loginPage.clickBySubmitBtn();
    }

    @Test(dataProvider = "emptyData", dataProviderClass = DataProviderLogin.class)
    public void authorizationUserEmptyData(String email, String password, String emailMessage, String passwordMessage) throws InterruptedException {
        LoginPage loginPage = test1(email, password);
        Assert.assertTrue(loginPage.isEmailErrorMessageEqual(emailMessage)
                & loginPage.isPasswordErrorMessageEqual(passwordMessage));
    }


    @Test(dataProvider = "emptyPassword", dataProviderClass = DataProviderLogin.class)
    public void authorizationUserEmptyPassword(String email, String password, String passwordMessage) {
        StartPage startPage = new StartPage(driver);
        startPage.openURL();
        startPage.openAccountWindow();
        LoginPage loginPage = startPage.clickByLoginBtn();
        loginPage.typeEmailByInputField(email);
        loginPage.typePasswordByInputField(password);
        loginPage.clickBySubmitBtn();
        Assert.assertTrue(loginPage.isPasswordErrorMessageEqual(passwordMessage)
                & !loginPage.isPresentWebElementEmailErrorMessage());
    }


    @Test(dataProvider = "emptyEmail", dataProviderClass = DataProviderLogin.class)
    public void authorizationUserEmptyEmail(String email, String password, String emailMessage) throws InterruptedException {
        StartPage startPage = new StartPage(driver);
        startPage.openURL();
        startPage.openAccountWindow();
        LoginPage loginPage = startPage.clickByLoginBtn();
        loginPage.typeEmailByInputField(email);
        loginPage.typePasswordByInputField(password);
        loginPage.clickBySubmitBtn();
        Assert.assertTrue(loginPage.isEmailErrorMessageEqual(emailMessage)
                & !loginPage.isPresentWebElementPasswordErrorMessage());
    }


    @Test(dataProvider = "notRegisteredEmail", dataProviderClass = DataProviderLogin.class)
    public void authorizationUserEmailIsNotRegistered(String email, String password, String emailMessage) throws InterruptedException {
        StartPage startPage = new StartPage(driver);
        startPage.openURL();
        startPage.openAccountWindow();
        LoginPage loginPage = startPage.clickByLoginBtn();
        loginPage.typeEmailByInputField(email);
        loginPage.typePasswordByInputField(password);
        loginPage.clickBySubmitBtn();
        Assert.assertTrue(loginPage.isEmailErrorMessageEqual(emailMessage)
                & !loginPage.isPresentWebElementPasswordErrorMessage());
    }


}
