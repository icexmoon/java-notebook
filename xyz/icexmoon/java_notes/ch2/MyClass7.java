package ch2;

import java.util.Random;

public class MyClass7 {
    private int number;
    public MyClass7(){
        Random rand = new Random();
        int randInt = rand.nextInt(100);
        // this(randInt);
    }
    public MyClass7(int number){
        this.number = number;
    }
    @Override
    public String toString() {
        return Integer.toString(number);
    }
    public static void main(String[] args) {
        MyClass7 mc = new MyClass7();
        System.out.println(mc);
        // 100
    }
}
