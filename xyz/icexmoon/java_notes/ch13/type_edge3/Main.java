package ch13.type_edge3;

interface EatAble {
    public void eat();
}

class GenericClass<T extends EatAble> {
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
        GenericClass<EatAble> gc = new GenericClass<>();
        gc.set(new EatAble() {
            @Override
            public void eat() {
                System.out.println("eating someting...");
            }
        });
        System.out.println(gc.get());
        gc.eat();
    }
}
// ch13.type_edge3.Main$1@372f7a8d
// eating someting...