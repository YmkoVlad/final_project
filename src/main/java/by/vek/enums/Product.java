package by.vek.enums;

public enum Product {

    DENTALFLOSS("Зубная нить"),
    BIKE("Велосипед"),
    SMARTPHONE("Смартфон"),
    PUMP("Насос");

    private String productName;

    Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
}
