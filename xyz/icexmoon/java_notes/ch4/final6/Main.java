package ch4.final6;

class Parent {
    private void test() {
        System.out.println("Parent.test() is called.");
    }
}

class Child extends Parent {
    private void test(){
        System.out.println("Child.test() is called.");
    }

    public void callTest(){
        this.test();
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        c.callTest();
        // Child.test() is called.
    }
}
