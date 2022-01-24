package ch10.dispose2;

class MyExp extends Exception {
}

public class Main {
    private static void throwMyExp() {
        try {
            throw new MyExp();
        } finally {
            return;
        }
    }

    public static void main(String[] args) {
        throwMyExp();
    }
}
