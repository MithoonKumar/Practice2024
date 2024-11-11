package interview.uber.cartExpiryLibrary;

/*
Cart
Item
User
CartManager
CartState

*/



public class Main {

    public static void main(String[] args) throws InterruptedException {
        CartManager cartManager = new CartManager(2, 10);
        User user = new User();
        String userId = user.getUserId();
        Cart cart = cartManager.createCart(userId);
        cart.addItemsToCart(new Item("maggie", "123"));
        //cart.checkoutCart();

        Cart cart1 = cartManager.createCart(userId);
        cart1.addItemsToCart(new Item("toothpaste", "1234"));
        System.out.println(cart1.getCartId());

        Thread.sleep(20000L);
        cartManager.shutdownExecutor();
    }
}
