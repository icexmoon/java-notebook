package ch7.why3;

class A {
    private void funcA() {
        System.out.println("funcA() is called.");
    }

    class B {
        private void funcB() {
            System.out.println("funcB() is called.");
        }

        class C {
            public void funcC(){
                funcA();
                funcB();
            }
        }
    }

}

public class Main {
    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        c.funcC();
    }
}
