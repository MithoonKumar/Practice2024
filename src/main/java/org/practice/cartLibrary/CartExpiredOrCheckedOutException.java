package org.practice.cartLibrary;

public class CartExpiredOrCheckedOutException extends RuntimeException {

    public CartExpiredOrCheckedOutException(String message) {
        super(message);
    }
}
