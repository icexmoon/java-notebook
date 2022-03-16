package ch15.generic2;

import java.util.ArrayList;
import java.util.List;

class Fruit {
}

class Apple extends Fruit {
}

class Orange extends Fruit {
}

public class Main {
    public static void main(String[] args) {
        Apple[] apples = new Apple[10];
        Fruit[] fruits = apples;
        fruits[0] = new Orange();
        // Exception in thread "main" java.lang.ArrayStoreException:
        // ch15.generic2.Orange
        // at ch15.generic2.Main.main(Main.java:16)
        List<Apple> apples2 = new ArrayList<>();
        // List<Fruit> fruits2 = apples2;
        // Type mismatch: cannot convert from List<Apple> to List<Fruit>Java(16777233)

    }
}
