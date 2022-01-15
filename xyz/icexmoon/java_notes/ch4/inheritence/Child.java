package ch4.inheritence;

class Parent{

}

public class Child extends Parent {
    public static void main(String[] args) {
        Child c = new Child();
        if (c instanceof Object){
            System.out.println("c is Object.");
        }
        if (c instanceof Parent){
            System.out.println("c is Parent.");
        }
        if (c instanceof Child){
            System.out.println("c is Child.");
        }
        // c is Object.
        // c is Parent.
        // c is Child.
    }
}
