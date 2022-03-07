package ch13.wildcard3;

import java.util.ArrayList;
import java.util.List;

class Fruit {
}

class Apple extends Fruit {
}

public class Main {
    public static void main(String[] args) {
        List<? extends Fruit> fruits = new ArrayList<Apple>();
        // fruits.add(new Fruit());
        // The method add(capture#1-of ? extends Fruit) in the type List<capture#1-of ?
        // extends Fruit> is not applicable for the arguments (Fruit)
        // fruits.add(new Apple());
        // The method add(capture#2-of ? extends Fruit) in the type List<capture#2-of ?
        // extends Fruit> is not applicable for the arguments (Apple)
        fruits.add(null);
        Fruit f = fruits.get(0);
    }
}
