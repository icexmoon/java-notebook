package ch2;

import java.util.Random;

public class MyClass6 {
    private int number;
    public MyClass6(){
        this(100);
    }
    public MyClass6(int number){
        this.number = number;
    }
    @Override
    public String toString() {
        return Integer.toString(number);
    }
    public static void main(String[] args) {
        MyClass6 mc = new MyClass6();
        System.out.println(mc);
        // 100
    }
}
