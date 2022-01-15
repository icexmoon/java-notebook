package ch3.other;

import ch3.my_class.MyClass;

public class MyChild extends MyClass {

    public MyChild(int num) {
        super(num);
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        MyChild mc = new MyChild(10);
        System.out.println(mc.num);
    }

}
