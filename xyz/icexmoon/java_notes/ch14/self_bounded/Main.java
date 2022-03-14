package ch14.self_bounded;

class BaseClass<T> {
    private T content;

    public void set(T content) {
        this.content = content;
    }

    public T get() {
        return content;
    }
}

class SubClass extends BaseClass<SubClass> {

}

public class Main {
    public static void main(String[] args) {
        SubClass sc = new SubClass();
        sc.set(new SubClass());
        System.out.println(sc.get());
    }
}
