package org.designPatterns.decoratorDesignPattern;

public class Main {

    public static void main(String[] args) {
        Coffee normalCoffee = new NormalCoffee();
        Coffee milkDecoratorCoffee = new MilkDecoratorCoffee(normalCoffee);
        System.out.println(milkDecoratorCoffee.getDescription());
        System.out.println(milkDecoratorCoffee.getCost());
    }
}
