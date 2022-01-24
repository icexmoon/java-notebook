package ch10.limit3;

class MyExp extends Exception {
}

class MyExp2 extends Exception {
}

class Parent {
    public Parent() throws MyExp {
    }
}

class Child extends Parent {

    public Child() throws MyExp, MyExp2 {
        super();
    }
}

public class Main {

    public static void main(String[] args) throws MyExp, MyExp2 {
        Parent parent = new Parent();
        Child child = new Child();
    }
}

