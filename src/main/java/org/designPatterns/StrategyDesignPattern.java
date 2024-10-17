package org.designPatterns;

public class StrategyDesignPattern {

    public static void main(String[] args) {
        PaymentStrategy cardPaymentStrategy = new CardPaymentStrategy();
        PaymentStrategy upiPaymentStrategy = new UPIPaymentStrategy();

        PaymentProcessor paymentProcessor = new PaymentProcessor(cardPaymentStrategy);

        paymentProcessor.pay(10);
        paymentProcessor.setPaymentStrategy(upiPaymentStrategy);
        paymentProcessor.pay(20);

    }
}

class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay (int amount) {
        this.paymentStrategy.pay(amount);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}



interface PaymentStrategy {
    void pay(int amount);
}

class CardPaymentStrategy implements PaymentStrategy{

    @Override
    public void pay(int amount) {
        System.out.println("Making a payment of " + amount + " using card");
    }
}

class UPIPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println("Making a payment of " + amount + " using UPI");
    }
}