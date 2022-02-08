package ch12.get_cls;

class MyClass {
}

public class Main {
    public static void main(String[] args) {
        Class clsRef1 = null;
        try {
            clsRef1 = Class.forName("ch12.get_cls.MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class clsRef2 = MyClass.class;
        System.out.println(clsRef1 == clsRef2);
    }
}
// true
