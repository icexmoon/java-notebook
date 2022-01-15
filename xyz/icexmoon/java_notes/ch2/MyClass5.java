package ch2;

import java.util.Random;

public class MyClass5 {
    private int number;
    public MyClass5(){
        Random rand = new Random();
        number = rand.nextInt(100);
    }
    public MyClass5(int number){
        this.number = number;
    }
    @Override
    public String toString() {
        return Integer.toString(number);
    }
    public static void main(String[] args) {
        MyClass5 mc = new MyClass5();
        System.out.println(mc);
        // 30
    }
}
