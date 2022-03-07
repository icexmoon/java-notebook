package ch13.type_edge6;

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

class GenericClass<T> {

    private T obj;

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }
}

class EatAbleFruit<T extends Fruit & EatAble> extends GenericClass<T> {
    public void eat() {
        get().eat();
    }
}

class JuicingEatAbleFruit<T extends Fruit & EatAble & JuicingAble> extends EatAbleFruit<T> {
    public void juicing(){
        get().juicing();
    }
}

public class Main {
    public static void main(String[] args) {
        JuicingEatAbleFruit<Orange> jef = new JuicingEatAbleFruit<>();
        jef.set(new Orange());
        jef.eat();
        jef.juicing();
    }
}
// eating orange...
// juicing orange...