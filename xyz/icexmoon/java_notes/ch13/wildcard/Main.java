package ch13.wildcard;

class Fruit {
}

class Apple extends Fruit {
}

public class Main {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Fruit();
        // Exception in thread "main" java.lang.ArrayStoreException: ch13.wildcard.Fruit
        // at ch13.wildcard.Main.main(Main.java:9)
    }
}
