package by.vek.enums;

public enum UserTest {

    EMAIL("kukharevich.vlad@gmail.com"),
    PASSWORD("19ae43ba");

    private String dataUser;

    UserTest(String dataUser) {
        this.dataUser = dataUser;
    }

    public String getDataUser() {
        return dataUser;
    }
}
