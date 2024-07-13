package by.vek.enums;

public enum ErrorMesageAPI {

    CHECKEMAIL("Проверьте email"),
    WRONGPASSWORD("Длина поля password должна быть от 6 до 32 символов");

    private String message;

    ErrorMesageAPI(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
