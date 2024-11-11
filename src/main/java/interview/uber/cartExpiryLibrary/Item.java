package interview.uber.cartExpiryLibrary;

public class Item {
    private String name;
    private String itemId;

    public Item(String name, String itemId) {
        this.name = name;
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }
}
