package ch2.multi_params;

public class Main {
    private static void multiParamsMethod(Object[] params) {
        for (Object param : params) {
            System.out.print(param + ", ");
        }
    }

    public static void main(String[] args) {
        Object[] params = new Object[3];
        params[0] = 1;
        params[1] = "Hello world!";
        params[2] = 2.5;
        multiParamsMethod(params);
        // 1, Hello world!, 2.5, 
    }
}
