package ch13.type_edge4;

interface EatAble {
    public void eat();
}

class Fruit {
}

class Apple extends Fruit {
}

class Orange extends Fruit implements EatAble {
    @Override
    public void eat() {
        System.out.println("eating orange...");
    }
}

class GenericClass<T extends Fruit & EatAble> {
    // class GenericClass<T extends EatAble & Fruit> {
    // The type Fruit is not an interface; it cannot be specified as a bounded
    // parameter

    private T obj;

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }

    public void eat() {
        obj.eat();
    }
}

public class Main {
    public static void main(String[] args) {
        GenericClass<Orange> gc = new GenericClass<>();
        // GenericClass<Apple> gc2 = new GenericClass<>();
        // Bound mismatch: The type Apple is not a valid substitute for the bounded
        // parameter <T extends Fruit & EatAble> of the type GenericClass<T>
    }
}