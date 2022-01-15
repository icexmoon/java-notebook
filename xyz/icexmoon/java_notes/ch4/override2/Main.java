package ch4.override2;

import util.Fmt;

class Parent{
    public void func(int i){
        Fmt.printf("func(int %d) is called.\n", i);
    }

    public void func(char c){
        Fmt.printf("func(char %s) is called.\n", c);
    }
}

class Child extends Parent{
    // @Override
    // public void func(String str) {
    //     Fmt.printf("func(String %s) is called.\n", str);
    // }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        // c.func("123");
        c.func(123);
        c.func('a');
        // func(String 123) is called.
        // func(int 123) is called.
        // func(char a) is called.
    }
}
