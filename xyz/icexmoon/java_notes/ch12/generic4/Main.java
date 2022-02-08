package ch12.generic4;

class Parent {
}

class Child extends Parent {
}

public class Main {
    public static void main(String[] args) {
        Class<? extends Parent> cls;
        cls = Parent.class;
        cls = Child.class;
        Class<? super Child> cls2;
        cls2 = Parent.class;
        cls2 = Child.class.getSuperclass();
        cls2 = Child.class;
    }
}