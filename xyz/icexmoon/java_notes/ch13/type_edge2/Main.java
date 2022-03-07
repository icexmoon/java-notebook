package ch13.type_edge2;

abstract class Fruit {
    abstract public void eat();
}

class Apple extends Fruit {
    @Override
    public void eat() {
        System.out.println("eating apple...");
    }
}

class Orange extends Fruit {
    @Override
    public void eat() {
        System.out.println("eating orange...");
    }
}

class GenericClass<T extends Fruit> {
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
        GenericClass<Apple> gc = new GenericClass<>();
        gc.set(new Apple());
        System.out.println(gc.get());
        gc.eat();
    }
}
// ch13.type_edge2.Apple@372f7a8d
// eating apple...