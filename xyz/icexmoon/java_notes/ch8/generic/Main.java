package ch8.generic;

import java.util.ArrayList;
import java.util.List;

import util.Fmt;

class Apple {
    private static int counter = 0;
    private int id = ++counter;

    public void eat() {
        Fmt.printf("Apple(%d) is eated.\n", id);
    }
}

class Orange {
}

class RedApple extends Apple {
}

class GreenApple extends Apple {
}

public class Main {
    private static void printApples(List apples) {
        for (Object object : apples) {
            Apple apple = (Apple) object;
            apple.eat();
        }
    }

    public static void main(String[] args) {
        List apples = new ArrayList();
        apples.add(new Apple());
        apples.add(new RedApple());
        apples.add(new GreenApple());
        printApples(apples);
        // Apple(1) is eated.
        // Apple(2) is eated.
        // Apple(3) is eated.
        apples.add(new Orange());
        printApples(apples);
        // Apple(1) is eated.
        // Apple(2) is eated.
        // Apple(3) is eated.
        // Exception in thread "main" java.lang.ClassCastException: class
        // ch8.generic.Orange cannot be cast to class ch8.generic.Apple
        // (ch8.generic.Orange and ch8.generic.Apple are in unnamed module of loader
        // 'app')
        // at ch8.generic.Main.printApples(Main.java:29)
        // at ch8.generic.Main.main(Main.java:40)
    }
}
