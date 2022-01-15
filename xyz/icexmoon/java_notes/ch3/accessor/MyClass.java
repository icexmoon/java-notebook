package ch3.accessor;

public class MyClass {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        MyClass mc = new MyClass();
        mc.setNum(10);
        System.out.println(mc.getNum());
    }

}
