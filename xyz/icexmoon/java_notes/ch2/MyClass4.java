package ch2;

import java.util.Random;

public class MyClass4 {
    private int number;
    public MyClass4(){
        Random rand = new Random();
        number = rand.nextInt(100);
    }
    @Override
    public String toString() {
        return Integer.toString(number);
    }
    public static void main(String[] args) {
        MyClass4 mc = new MyClass4();
        System.out.println(mc);
        // 30
    }
}
