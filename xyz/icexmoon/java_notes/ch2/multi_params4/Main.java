package ch2.multi_params4;

public class Main {
    private static void multiParamsMethod(Object... params) {
        for (Object param : params) {
            System.out.print(param + ", ");
        }
        System.out.println();
    }

    private static void multiParamsMethod(){
        System.out.println("multiParamsMethod() is called.");
    }

    public static void main(String[] args) {
        multiParamsMethod();
    }
}
