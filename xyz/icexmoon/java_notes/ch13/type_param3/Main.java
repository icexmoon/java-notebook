package ch13.type_param3;

class GenericTest<T> {
    private T obj;

    public GenericTest(T obj) {
        this.obj = obj;
    }

    public void f() {
        // obj.f();
    }
}

class FCaller {
    public void f() {

    }
}

public class Main {
    public static void main(String[] args) {
        GenericTest<FCaller> gt = new GenericTest<>(new FCaller());
        gt.f();
    }
}
// The method f() is undefined for the type T