package ch7.func_inner2;

import java.util.Random;

import util.Fmt;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt(100);
        int b = random.nextInt(100);
        if (a > b) {
            class LocalInnerClass {
                @Override
                public String toString() {
                    return this.getClass().getName();
                }
            }
            LocalInnerClass lic = new LocalInnerClass();
            System.out.println(lic);
        }
        Fmt.printf("a:%d,b:%d\n", a, b);
        // ch7.func_inner2.Main$1LocalInnerClass
        // a:35,b:5
    }
}
