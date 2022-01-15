package ch2;

import java.util.Random;

public class MyInteger3 {
    private int number;

    public MyInteger3() {
        Random random = new Random();
        number = random.nextInt(100);
    }

    public MyInteger3(int number) {
        this.number = number;
    }

    public MyInteger3(char number) {
        System.out.println("char constructor is called.");
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(this.number);
    }

    public static void main(String[] args) {
        MyInteger3 mi = new MyInteger3('a');
        System.out.println(mi);
        // char constructor is called.
        // 97
    }
}