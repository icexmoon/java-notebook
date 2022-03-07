package ch13.type_edge;

class Fruit {
}

class Apple extends Fruit {
}

class Orange extends Fruit {
}

class GenericClass<T extends Fruit> {
    private T obj;

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }
}

public class Main {
    public static void main(String[] args) {
        GenericClass<Apple> gc = new GenericClass<>();
        gc.set(new Apple());
        System.out.println(gc.get());
    }
}
