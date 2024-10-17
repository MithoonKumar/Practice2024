package org.designPatterns;

public class FactoryDesignPattern {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape rectangle = shapeFactory.getShape("Rectangle");
        rectangle.draw();

        Shape square = shapeFactory.getShape("Square");
        square.draw();

    }

}


interface Shape {
    void draw();
}


class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("I am drawing a rectangle");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("I am drawing a square");
    }
}

class ShapeFactory {

    public Shape getShape(String shapeName) {
        if (shapeName.equals("Rectangle")) {
            return new Rectangle();
        } else if (shapeName.equals("Square")) {
            return new Square();
        } else {
            return null;
        }
    }
}