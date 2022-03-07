package ch13.wildcard7;

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
        // Main.<Apple>addItem2List(fruits, new Apple());
        // The parameterized method <Apple>addItem2List(List<Apple>, Apple) of type Main
        // is not applicable for the arguments (List<Fruit>, Apple)
        Main.<Fruit>addItem2List(fruits, new Apple());
        System.out.println(fruits);
    }

    private static <T> void addItem2List(List<T> list, T item) {
        list.add(item);
    }
}
