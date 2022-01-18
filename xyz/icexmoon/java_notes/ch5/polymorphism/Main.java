package ch5.polymorphism;

import java.util.Random;

class Shape {
    public void display() {
    }
}

class Rectangle extends Shape {
    @Override
    public void display() {
        super.display();
        System.out.println("Rectangle is displayed.");
    }
}

class Triangle extends Shape {
    @Override
    public void display() {
        super.display();
        System.out.println("Triangle is displayed.");
    }
}

class Circle extends Shape {
    @Override
    public void display() {
        super.display();
        System.out.println("Circle is displayed.");
    }
}

class ShapeFactory {
    private static Random random = new Random();

    public static Shape getRandomShape() {
        switch (random.nextInt(3)) {
            case 0:
                return new Rectangle();
            case 1:
                return new Circle();
            default:
                return new Triangle();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = ShapeFactory.getRandomShape();
        }
        for (Shape shape : shapes) {
            shape.display();
        }
        // Triangle is displayed.
        // Rectangle is displayed.
        // Rectangle is displayed.
        // Circle is displayed.
        // Rectangle is displayed.
    }
}
