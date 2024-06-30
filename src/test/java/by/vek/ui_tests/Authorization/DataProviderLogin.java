package by.vek.ui_tests.Authorization;

import org.testng.annotations.DataProvider;

public class DataProviderLogin {

    @DataProvider(name = "emptyData")
    public static Object[][] emptyData() {
        return new Object[][]{
                {"", "", "Электронная почта не указана", "Пароль не указан"}
        };
    }

    @DataProvider(name = "emptyPassword")
    public Object[][] emptyPassword() {
        return new Object[][]{
                {"Kukharevich.vlad@gmail.com", "", "Пароль не указан"}
        };
    }

    @DataProvider(name = "emptyEmail")
    public Object[][] emptyEmail() {
        return new Object[][]{
                {"", "123", "Электронная почта не указана"},
                {"", "abc", "Электронная почта не указана"},
                {"", "123abc!@#ABC", "Электронная почта не указана"}
        };
    }

    @DataProvider(name = "notRegisteredEmail")
    public Object[][] notRegisteredEmail() {
        return new Object[][]{
                {"P_d@gmail.com", "0)qQ1!wW", "Проверьте электронную почту или \nзарегистрируйтесь"},
                {"Ket_r@mail.ru", "1qaz!QAZ", "Проверьте электронную почту или \nзарегистрируйтесь"},
                {"Snata@gmail.com", "123abc!@#ABC", "Проверьте электронную почту или \nзарегистрируйтесь"}
        };
    }
}
