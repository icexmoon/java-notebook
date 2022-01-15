package ch2;

import java.util.Random;

public class MyInteger{
    private int number;

    public MyInteger(){
        Random random = new Random();
        number = random.nextInt(100);
    }

    public MyInteger(int number){
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(this.number);
    }
    public static void main(String[] args) {
        MyInteger mi = new MyInteger();
        MyInteger mi2 = new MyInteger(10);
        System.out.println(mi);
        System.out.println(mi2);
        // 99
        // 10
    }
}