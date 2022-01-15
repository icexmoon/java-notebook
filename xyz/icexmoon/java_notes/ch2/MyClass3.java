package ch2;

import java.util.Random;

public class MyClass3 {
    private int number;
    public MyClass3(){
        Random rand = new Random();
        this.number = rand.nextInt(100);
    }
    @Override
    public String toString() {
        return Integer.toString(this.number);
    }
    public static void main(String[] args) {
        MyClass3 mc = new MyClass3();
        System.out.println(mc);
        // 25
    }
}
