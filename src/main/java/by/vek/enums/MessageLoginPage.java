package by.vek.enums;

public enum ErrorMessageLoginPage {
    EMAILEMPTY("Электронная почта не указана"),
    PASSWORDEMPTY("Пароль не указан"),
    CHECKEMAIL("Проверьте электронную почту или \nзарегистрируйтесь"),
    WRONGPASSWORD("Неправильный пароль. \nСбросить пароль?");

    private String message;

    ErrorMessageLoginPage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}