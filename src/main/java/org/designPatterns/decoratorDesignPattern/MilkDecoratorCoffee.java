package org.designPatterns.decoratorDesignPattern;

public class MilkDecoratorCoffee implements Coffee {

    Coffee coffee;

    public MilkDecoratorCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + " and milk";
    }

    @Override
    public int getCost() {
        return this.coffee.getCost() + 10;
    }
}
