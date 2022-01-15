package ch2.multi_params6;

public class Main {
    private static void multiParamsMethod(Object... params) {
        for (Object param : params) {
            System.out.print(param + ", ");
        }
        System.out.println();
    }

    private static void multiParamsMethod(String... params) {
        System.out.println("multiParamsMethod(String...) is called.");
    }

    public static void main(String[] args) {
        multiParamsMethod();
        // multiParamsMethod(String...) is called.
    }
}
