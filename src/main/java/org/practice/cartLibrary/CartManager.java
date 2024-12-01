package org.practice.cartLibrary;

import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.*;

public class CartManager {
    ConcurrentHashMap<String, HashSet<String>> userCartSet;
    ConcurrentHashMap<String, Cart> cartHashMap;
    private Long expiryDuration;
    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);


    public CartManager(Long expiryDuration) {
        this.userCartSet = new ConcurrentHashMap<>();
        this.cartHashMap = new ConcurrentHashMap<>();
        this.expiryDuration = expiryDuration;

        executorService.scheduleAtFixedRate(()->{
            this.cartHashMap.forEach((key, value) -> {
                System.out.println(value.getCartState() + " cartId:" + value.getCartId());
                if (value.getCartState() == CartState.CREATED && System.currentTimeMillis() - value.getLastUpdateTimeStamp() > this.expiryDuration) {
                    value.expireCart();
                }
            });
        }, 1 , 1, TimeUnit.SECONDS);
    }

    public String createCartForUser(String userId) {
        Cart cart = new Cart(UUID.randomUUID().toString());
        HashSet<String> cartSet = this.userCartSet.getOrDefault(userId, new HashSet<>());
        cartSet.add(cart.getCartId());
        this.userCartSet.put(userId, cartSet);
        this.cartHashMap.put(cart.getCartId(), cart);
        return cart.getCartId();
    }

    public void addItemToCart(String userId, String cartId, Item item) {
        if (this.userCartSet.get(userId) != null && this.userCartSet.get(userId).contains(cartId)) {
            Cart cart = this.cartHashMap.get(cartId);
            if (cart.getCartState() == CartState.CREATED) {
                cart.addItemToCartAndUpdateTimeStamp(item);
            } else {
                throw new CartExpiredOrCheckedOutException("This cart is either expired or checkedout");
            }
        } else {
            throw new CartNotFoundException("Cart not found exception");
        }
    }

    public void removeItemFromCart(String userId, String cartId, Item item) {
        if (this.userCartSet.get(userId) != null && this.userCartSet.get(userId).contains(cartId)) {
            this.cartHashMap.get(cartId).removeItemFromCart(item);
            return;
        }
        throw new CartNotFoundException("Cart not found exception");
    }

    public void checkoutCart(String userId, String cartId) {
        if (this.userCartSet.get(userId) != null && this.userCartSet.get(userId).contains(cartId)) {
            this.cartHashMap.get(cartId).checkoutCart();
            return;
        }
        throw new CartNotFoundException("Cart not found exception");
    }




}
