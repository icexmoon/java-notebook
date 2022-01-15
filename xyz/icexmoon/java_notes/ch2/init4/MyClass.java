package ch2.init4;

import java.util.Random;

public class MyClass {
    MyClass2 mc2 = new MyClass2();
    int intMember;
    {
        Random random = new Random();
        intMember = random.nextInt(100);
    }
    String strMember = "";
    static int sintMember;
    static {
        Random random = new Random();
        sintMember = random.nextInt(100);
    }

    public static void main(String[] args) {
        MyClass mc = new MyClass();
        System.out.println(mc.mc2);
        System.out.println(mc.intMember);
        System.out.println(mc.strMember);
        // null
        // 68
        // null
        System.out.println(MyClass.sintMember);
        // 89
    }
}

class MyClass2 {

}
