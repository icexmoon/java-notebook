package ch8.aslist;

import java.util.Arrays;
import java.util.List;

class Fruit {
}

class Apple extends Fruit {
}

class Oranger extends Fruit {
}

class RedApple extends Apple {
}

class YellowApple extends Apple {
}

public class Main {
    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[] { new Apple(), new Oranger(), new RedApple(), new YellowApple() };
        List<Fruit> list = Arrays.asList(fruits);
        List<Fruit> list2 = Arrays.asList(new RedApple(), new YellowApple());
        System.out.println(list2);
    }
}
