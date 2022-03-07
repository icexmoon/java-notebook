package ch13.type_edge5;

interface EatAble {
    public void eat();
}

interface JuicingAble {
    public void juicing();
}

class Fruit {
}

class Apple extends Fruit {
}

class Orange extends Fruit implements EatAble, JuicingAble {
    @Override
    public void eat() {
        System.out.println("eating orange...");
    }

    public void juicing() {
        System.out.println("juicing orange...");
    }
}

class GenericClass<T extends Fruit & EatAble & JuicingAble> {

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

    public void juicing() {
        obj.juicing();
    }
}

public class Main {
    public static void main(String[] args) {
        GenericClass<Orange> gc = new GenericClass<>();
        gc.set(new Orange());
        gc.eat();
        gc.juicing();
    }
}
// eating orange...
// juicing orange...