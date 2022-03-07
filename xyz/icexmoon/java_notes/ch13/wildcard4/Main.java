package ch13.wildcard4;

class GenericClass<T> {
    private T obj;

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }

    @Override
    public boolean equals(Object other) {
        if (obj == null) {
            if (other == null) {
                return true;
            } else {
                return false;
            }
        }
        return obj.equals(other);
    }
}

class Fruit {
};

class Apple extends Fruit {
};

public class Main {
    public static void main(String[] args) {
        GenericClass<? extends Fruit> gc = new GenericClass<Apple>();
        // gc.set(new Apple());
        System.out.println(gc.equals(new Apple()));
    }
}
