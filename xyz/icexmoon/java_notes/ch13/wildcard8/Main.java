package ch13.wildcard8;

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
        Main.<Fruit>addItem2List(fruits, new Fruit());
        Main.<Apple>addItem2List(apples, new Apple());
        Main.<Apple>addItem2List(fruits, new Apple());
        Main.<Fruit>addItem2List(fruits, new Apple());
        System.out.println(fruits);
    }

    private static <T> void addItem2List(List<? super T> list, T item) {
        list.add(item);
    }
}
