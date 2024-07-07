package by.vek.ui_tests.authorization;

import by.vek.enums.MessageLoginPage;
import org.testng.annotations.DataProvider;

public class DataProviderLogin {

    @DataProvider(name = "emptyData")
    public static Object[][] emptyData() {
        return new Object[][]{
                {"", "", MessageLoginPage.EMAILEMPTY.getMessage(), MessageLoginPage.PASSWORDEMPTY.getMessage()}
        };
    }

    @DataProvider(name = "emptyPassword")
    public Object[][] emptyPassword() {
        return new Object[][]{
                {"Kukharevich.vlad@gmail.com", "", MessageLoginPage.PASSWORDEMPTY.getMessage()},
                {"wfloorballd@gmail.com", "", MessageLoginPage.PASSWORDEMPTY.getMessage()},
                {"tck_ymko@mail.ru", "", MessageLoginPage.PASSWORDEMPTY.getMessage()}
        };
    }

    @DataProvider(name = "emptyEmail")
    public Object[][] emptyEmail() {
        return new Object[][]{
                {"", "1b", MessageLoginPage.EMAILEMPTY.getMessage()},
                {"", "ABC!@#", MessageLoginPage.EMAILEMPTY.getMessage()},
                {"", "aB1#_vlad", MessageLoginPage.EMAILEMPTY.getMessage()}
        };
    }

    @DataProvider(name = "notRegisteredEmail")
    public Object[][] notRegisteredEmail() {
        return new Object[][]{
                {"P_d@gmail.com", "0)qQ1!wW", MessageLoginPage.CHECKEMAIL.getMessage()},
                {"Ket_r@mail.ru", "1qaz!QAZ", MessageLoginPage.CHECKEMAIL.getMessage()},
                {"Snata@gmail.com", "123abc!@#ABC", MessageLoginPage.CHECKEMAIL.getMessage()}
        };
    }

    @DataProvider(name = "wrongEmail")
    public Object[][] wrongEmail() {
        return new Object[][]{
                {"wfloorballd@gmail.com", "123", MessageLoginPage.WRONGPASSWORD.getMessage()},
                {"Vlad_kukharevich@gmail.com", "abcd", MessageLoginPage.WRONGPASSWORD.getMessage()},
                {"tck_ymko@mail.ru", "1s", MessageLoginPage.WRONGPASSWORD.getMessage()}
        };
    }
}
