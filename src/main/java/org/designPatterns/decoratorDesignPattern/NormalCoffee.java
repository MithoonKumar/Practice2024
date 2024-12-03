package org.designPatterns.decoratorDesignPattern;

public class NormalCoffee implements Coffee{
    @Override
    public String getDescription() {
        return "This coffee contains caffeine";
    }

    @Override
    public int getCost() {
        return 10;
    }
}
