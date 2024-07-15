package by.vek.enums;

public enum ProductIndex {

    PRODUCTINDEXINPAGE(0),
    PRODUCTINDEXINCART(0);

    private int index;

    ProductIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
