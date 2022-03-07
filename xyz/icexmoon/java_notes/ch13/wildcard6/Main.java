package ch13.wildcard6;

import java.util.ArrayList;
import java.util.List;

class Fruit {
}

class Apple extends Fruit {
}

public class Main {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();
        List<Apple> apples = new ArrayList<>();
        addItem2List(fruits, new Fruit());
        addItem2List(apples, new Apple());
        addItem2List(fruits, new Apple());
        System.out.println(fruits);
    }

    private static <T> void addItem2List(List<T> list, T item) {
        list.add(item);
    }
}
