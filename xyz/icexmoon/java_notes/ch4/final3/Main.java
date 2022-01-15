package ch4.final3;

class MyClass {
    private final int num;

    public MyClass(int num) {
        this.num = num;
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass mc = new MyClass(10);
    }
}
