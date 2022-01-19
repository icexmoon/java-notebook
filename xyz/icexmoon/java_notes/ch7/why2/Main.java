package ch7.why2;

interface InterA {
    void test();
}

interface InterB {
    int test();
}

class MyClass implements InterA {

    @Override
    public void test() {
        System.out.println("test() is called.");
    }

    public InterB getInterB() {
        return new InterB() {

            @Override
            public int test() {
                return 0;
            }

        };
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass mc = new MyClass();
        InterB ib = mc.getInterB();
        InterA ia = mc;
    }
}
