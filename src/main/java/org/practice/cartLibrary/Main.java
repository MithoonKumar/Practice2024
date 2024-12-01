package org.practice.cartLibrary;

/*
Cart
User
CartState
Item
CartManager

Functionality to be supported by the cart
1. Add items to the cart
2. remove items from the cart
3. checkout the cart
4. Expires a cart if not checked out within an period

*/


public class Main {

    public static void main(String[] args) throws InterruptedException {
        User user = new User("Mithoon", "Mithoon", "Mithoon");
        CartManager cartManager = new CartManager(10000L);;
        String cartId = cartManager.createCartForUser(user.getUserId());
        Item item = new Item("1", "one");
        cartManager.addItemToCart(user.getUserId(), cartId, item);
    }
}
