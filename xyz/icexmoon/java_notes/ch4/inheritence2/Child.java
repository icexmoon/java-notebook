package ch4.inheritence2;

class Parent{
    public void display(){
        System.out.println("Parent is displayed.");
    }

    public void desdroy(){
        System.out.println("parent is desdroyed.");
    }
}

public class Child extends Parent {
    @Override
    public void display() {
        super.display();
        System.out.println("Child is desplayed.");
    }

    @Override
    public void desdroy() {
        System.out.println("Child is desdroyed.");
        super.desdroy();
    }
    public static void main(String[] args) {
        Child c = new Child();
        c.display();
        c.desdroy();
        // Parent is displayed.
        // Child is desplayed.
        // Child is desdroyed.
        // parent is desdroyed.
    }
}
