package ch2.multi_params5;

public class Main {
    private static void multiParamsMethod(Integer... params) {
        System.out.println("multiParamsMethod(Integer...) is called.");
    }

    private static void multiParamsMethod(String... params) {
        System.out.println("multiParamsMethod(String...) is called.");
    }

    public static void main(String[] args) {
        // multiParamsMethod();
    }
}
