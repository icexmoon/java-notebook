package ch2;

import java.util.Random;

public class MyInteger2 {
    private int number;

    public MyInteger2() {
        Random random = new Random();
        number = random.nextInt(100);
    }

    public MyInteger2(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(this.number);
    }

    public static void main(String[] args) {
        MyInteger2 mi = new MyInteger2('a');
        System.out.println(mi);
        // 97
    }
}