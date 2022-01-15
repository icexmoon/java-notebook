package ch4.protected1;

import util.Fmt;

class Parent{
    private int num;

    protected int getNum() {
        return num;
    }

    protected void setNum(int num) {
        this.num = num;
    }
}

class Child extends Parent{

    public Child(int num) {
        super();
        super.setNum(num);
    }

    public void display(){
        Fmt.printf("num:%d\n", super.getNum());
    }

    public void clean(){
        super.setNum(0);
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child(10);
        c.display();
        c.clean();
        c.display();
        // num:10
        // num:0
    }
}
