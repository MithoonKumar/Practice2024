package interview.uber.cartExpiryLibrary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CartManager {
    private HashMap<String, Cart> cartsMap;
    private HashMap<String, HashSet<String>> userCartSet;
    private ScheduledExecutorService scheduledExecutorService;
    private int cartExpiryTime;

    public CartManager(int corePoolSize, int cartExpiryTime) {
        scheduledExecutorService = Executors.newScheduledThreadPool(corePoolSize);
        cartsMap = new HashMap<>();
        userCartSet = new HashMap<>();
        this.cartExpiryTime = cartExpiryTime;
    }


    public Cart createCart(String userId) {
        Cart cart = new Cart();
        cartsMap.put(cart.getCartId(), cart);
        HashSet<String> cartSet = userCartSet.getOrDefault(userId, new HashSet<>());
        cartSet.add(cart.getCartId());
        userCartSet.put(userId, cartSet);
        scheduleCartExpiry(cart, userId);
        return cart;
    }


    private void scheduleCartExpiry(Cart cart, String userId) {
        Runnable runnable = () -> {
            if (!cart.isCheckedOut()) {
                System.out.println("The cart with id:" + cart.getCartId() + " is being deleted");
                this.deleteCart(cart.getCartId(), userId);
            }
        };
        scheduledExecutorService.schedule(runnable, this.cartExpiryTime, TimeUnit.SECONDS);
    }

    private void deleteCart(String cartId, String userId) {
        this.cartsMap.remove(cartId);
        this.userCartSet.get(userId).remove(cartId);
    }

    public void shutdownExecutor() {
        try {
            if (!this.scheduledExecutorService.awaitTermination(60, TimeUnit.SECONDS)) {
                this.scheduledExecutorService.shutdown();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
