package interview.uber.cartExpiryLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Cart {
    private String cartId;
    private List<Item> itemList;
    private CartState cartState;

    public Cart() {
        this.cartId = UUID.randomUUID().toString();
        itemList = new ArrayList<>();
        cartState = CartState.CREATED;
    }

    public void addItemsToCart(Item item) {
        this.itemList.add(item);
    }

    public void removeItemFromCart(Item item) {
        this.itemList.removeIf(item1 -> Objects.equals(item1.getItemId(), item.getItemId()));
    }

    public void checkoutCart() {
        this.cartState = CartState.CHECKEDOUT;
    }

    public boolean isCheckedOut() {
        return this.cartState == CartState.CHECKEDOUT;
    }


    public String getCartId() {
        return cartId;
    }
}
