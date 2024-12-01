package org.practice.cartLibrary;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String cartId;
    private List<Item> itemList;
    private CartState cartState;
    private Long lastUpdateTimeStamp;

    public Cart(String cartId) {
        this.cartId = cartId;
        this.cartState = CartState.CREATED;
        this.itemList = new ArrayList<>();
        this.setLastUpdateTimeStamp();
    }

    public void addItemToCartAndUpdateTimeStamp(Item item) {
        this.itemList.add(item);
        setLastUpdateTimeStamp();
    }

    public void removeItemFromCart(Item item) {
        itemList.remove(item);
        this.setLastUpdateTimeStamp();
    }

    public void checkoutCart() {
        this.cartState = CartState.CHECKED_OUT;
    }

    private void setLastUpdateTimeStamp() {
        this.lastUpdateTimeStamp = System.currentTimeMillis();
    }

    public void expireCart() {
        this.cartState = CartState.EXPIRED;
    }

    public CartState getCartState() {
        return cartState;
    }

    public Long getLastUpdateTimeStamp() {
        return lastUpdateTimeStamp;
    }

    public String getCartId() {
        return cartId;
    }
}
