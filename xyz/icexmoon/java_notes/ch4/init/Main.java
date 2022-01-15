package ch4.init;

import java.util.Random;

class MyClass{
    private int num;
    private static int snum;
    private static Random random;
    static{
        random = new Random();
        snum = random.nextInt(100);
        System.out.println("static members inilize is executed.");
    }
    {
        num = random.nextInt(100);
        System.out.println("normal members inilize is executed.");
    }
    public MyClass(){
        System.out.println("constructor is called.");
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass mc = new MyClass();
        // static members inilize is executed.
        // normal members inilize is executed.
        // constructor is called.
    }
}
