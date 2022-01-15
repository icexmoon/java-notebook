package ch2.multi_params3;

public class Main {
    private static void multiParamsMethod(Object... params) {
        for (Object param : params) {
            System.out.print(param + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        multiParamsMethod(1, 2, 3);
        multiParamsMethod("hello", "world");
        // 1, 2, 3, 
        // hello, world,
    }
}
