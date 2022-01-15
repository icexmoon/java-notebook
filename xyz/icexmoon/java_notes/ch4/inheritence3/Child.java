package ch4.inheritence3;

import util.Fmt;

class Parent {
    private int number;

    public Parent(int number) {
        this.number = number;
        Fmt.printf("Parent(%d) is called.\n", number);
    }

}

public class Child extends Parent {
    

    public Child(int number) {
        super(number);
        Fmt.printf("Child(%d) is called.\n", number);
    }

    public static void main(String[] args) {
        Child c = new Child(1);
        // Parent(1) is called.
        // Child(1) is called.
    }
}
