package ch13.type_param4;

class GenericTest<T extends FCaller> {
    private T obj;

    public GenericTest(T obj) {
        this.obj = obj;
    }

    public void f() {
        obj.f();
    }
}

class FCaller {
    public void f() {
        System.out.println("FCaller's f function is called.");
    }
}

public class Main {
    public static void main(String[] args) {
        GenericTest<FCaller> gt = new GenericTest<>(new FCaller());
        gt.f();
    }
}
// FCaller's f function is called.