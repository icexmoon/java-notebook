package ch3.private1;

import java.util.Random;

import util.Fmt;

class Number {
    private int num;

    public Number(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Number(%d)", this.num);
    }

    public void add(Number otherNumber) {
        this.num += otherNumber.num;
    }

    public static Number add(Number num1, Number num2) {
        return new Number(num1.num + num2.num);
    }

}

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Number num1 = new Number(random.nextInt(10));
        Number num2 = new Number(random.nextInt(10));
        Fmt.printf("num1:%s\n", num1);
        Fmt.printf("num2:%s\n", num2);
        num1.add(num2);
        Fmt.printf("num1:%s\n", num1);
        Fmt.printf("num1+num2=%s", Number.add(num1, num2));
        // num1:Number(8)
        // num2:Number(2)
        // num1:Number(10)
        // num1+num2=Number(12)
    }
}
