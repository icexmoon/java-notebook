package ch5.constructor;

class Parent {
    private String attr = "Parent.attr";

    public Parent() {
        System.out.println("Parent's constructor start.");
        displayAttr();
        System.out.println("Parent's Constructor end.");
    }

    public void displayAttr() {
        System.out.println("Parent.displayAttr:" + attr);
    }
}

class Child extends Parent {
    private String attr = "Child.attr";

    public Child() {
        super();
        System.out.println("Child's constructor start.");
        displayAttr();
        System.out.println("Child's constructor end.");
    }

    @Override
    public void displayAttr() {
        System.out.println("Child.displayAttr:" + attr);
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        // Parent's constructor start.
        // Child.displayAttr:null
        // Parent's Constructor end.
        // Child's constructor start.
        // Child.displayAttr:Child.attr
        // Child's constructor end.
    }
}
