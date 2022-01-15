package ch4.final4;

class MyClass {
    private final int num;

    public MyClass(int num) {
        this.num = num;
    }

    public void passNum(final int num){
        // num = 123;
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass mc = new MyClass(10);
    }
}
