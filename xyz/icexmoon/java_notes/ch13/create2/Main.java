package ch13.create2;

abstract class GenericClass<T> {
    private T instance;

    public GenericClass() {
        instance = create();
    }

    abstract protected T create();

    public T getInstance() {
        return instance;
    }
}

class SubClass extends GenericClass<String> {

    @Override
    protected String create() {
        return "hello";
    }

}

public class Main {
    public static void main(String[] args) {
        SubClass sc = new SubClass();
        System.out.println(sc.getInstance());
    }
}
// hello
