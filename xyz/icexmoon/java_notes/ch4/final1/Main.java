package ch4.final1;

class MyInteger{
    private int num;

    public MyInteger(int num) {
        this.setNum(num);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

public class Main {
    public static void main(String[] args) {
        final int num = 123;
        // num = 222;
        final String msg = "hello";
        // msg = "world";
        final MyInteger mi = new MyInteger(10);
        mi.setNum(20);
        System.out.println(mi.getNum());
        // 20
    }
}
