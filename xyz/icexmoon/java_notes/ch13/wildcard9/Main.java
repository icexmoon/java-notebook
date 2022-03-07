package ch13.wildcard9;

import java.util.Arrays;
import java.util.List;

class FirstItemGetter<T> {
    public T get(List<T> list) {
        return list.get(0);
    }
}

class Fruit {
};

class Apple extends Fruit {
}

public class Main {
    public static void main(String[] args) {
        List<Fruit> fruits = Arrays.asList(new Fruit());
        List<Apple> apples = Arrays.asList(new Apple());
        FirstItemGetter<Fruit> fig = new FirstItemGetter<>();
        Fruit f = fig.get(fruits);
        System.out.println(f);
        // Fruit f2 = fig.get(apples);
        // The method get(List<Fruit>) in the type FirstItemGetter<Fruit> is not
        // applicable for the arguments (List<Apple>)
        // System.out.println(f2);
    }
}
