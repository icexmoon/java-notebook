package ch5.attr;

class Parent {
    public String attr = "Parent.attr";

    public static void test() {
        System.out.println("Parent.test() is called.");
    }
}

class Child extends Parent {
    public String attr = "Child.attr";

    public static void test() {
        System.out.println("Child.test() is called.");
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        System.out.println(c.attr);
        Parent p = c;
        System.out.println(p.attr);
        // Child.attr
        // Parent.attr
        c.test();
        p.test();
        // Child.test() is called.
        // Parent.test() is called.
    }
}
