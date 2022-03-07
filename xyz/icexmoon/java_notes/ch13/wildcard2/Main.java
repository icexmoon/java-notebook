package ch13.wildcard2;

import java.util.ArrayList;
import java.util.List;

class Fruit {
}

class Apple extends Fruit {
}

public class Main {
    public static void main(String[] args) {
        // List<Fruit> fruits = new ArrayList<Apple>();
        // Type mismatch: cannot convert from ArrayList<Apple> to List<Fruit>
    }
}
