package ch4.proxy;

class MyClass{
    public void print(String str){
        System.out.println("print() is called.");
        System.out.println(str);
    }
}

class MyClassProxy{
    MyClass mc = new MyClass();
    public void print(String str){
        mc.print(str);
    }
}

public class Main {
    public static void main(String[] args) {
        MyClassProxy mcp = new MyClassProxy();
        mcp.print("hello");
        // print() is called.
        // hello
    }
}
