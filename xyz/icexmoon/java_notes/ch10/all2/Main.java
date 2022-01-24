package ch10.all2;

import java.util.Random;

class MyException1 extends Exception {
}

class MyException2 extends Exception {
}

class MyException3 extends Exception {
}

public class Main {
    private static void throwExp(int i) throws MyException1, MyException2, MyException3 {
        if (i < 3) {
            throw new MyException1();
        } else if (i >= 6) {
            throw new MyException2();
        } else {
            throw new MyException3();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        try {
            throwExp(random.nextInt(10));
        } catch (Exception e) {
            System.out.println("e:" + e);
        }
    }
}
