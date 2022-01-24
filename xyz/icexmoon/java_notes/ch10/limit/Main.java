package ch10.limit;

class MyExp extends Exception {
}

class MyExp2 extends Exception {
}

class Parent {
    public void test() throws MyExp {
    }
}

class Child extends Parent {
    // @Override
    // public void test() throws MyExp,MyExp2 {
    //     super.test();
    // }
}

public class Main {
    private static void dealParent(Parent parent) {
        try {
            parent.test();
        } catch (MyExp e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Parent parent = new Parent();
        dealParent(parent);
        Child child = new Child();
        dealParent(child);
    }
}
