package ch2.init3;

import java.util.Random;

public class MyClass {
    MyClass2 mc2 = new MyClass2();
    int intMember;
    {
        Random random = new Random();
        intMember = random.nextInt(100);
    }
    String strMember = "";

    public static void main(String[] args) {
        MyClass mc = new MyClass();
        System.out.println(mc.mc2);
        System.out.println(mc.intMember);
        System.out.println(mc.strMember);
        // null
        // 68
        // null
    }
}

class MyClass2 {

}
