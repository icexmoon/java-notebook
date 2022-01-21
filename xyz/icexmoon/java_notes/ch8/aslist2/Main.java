package ch8.aslist2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        List<Fruit> fruits = new ArrayList<Fruit>();
        fruits.addAll(Arrays.asList(new RedApple(), new YellowApple()));
        System.out.println(fruits);
        fruits.clear();
        Collections.addAll(fruits, new RedApple(), new YellowApple());
        System.out.println(fruits);
        // [ch8.aslist2.RedApple@2f92e0f4, ch8.aslist2.YellowApple@28a418fc]
        // [ch8.aslist2.RedApple@5305068a, ch8.aslist2.YellowApple@1f32e575]
    }
}
