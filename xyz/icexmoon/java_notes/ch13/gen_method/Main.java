package ch13.gen_method;

class Test {
    public static <T> void genericMthod(T param) {
        System.out.println("param type is " + param.getClass().getSimpleName());
    }
}

public class Main {
    public static void main(String[] args) {
        Test.genericMthod(1);
        Test.genericMthod("hello");
    }
}
// param type is Integer
// param type is String