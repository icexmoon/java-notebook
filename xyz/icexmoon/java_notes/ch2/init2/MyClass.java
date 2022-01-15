package ch2.init2;

public class MyClass {
    MyClass2 mc2 = new MyClass2();
    int intMember = 10;
    String strMember = "";

    public static void main(String[] args) {
        MyClass mc = new MyClass();
        System.out.println(mc.mc2);
        System.out.println(mc.intMember);
        System.out.println(mc.strMember);
        // null
        // 0
        // null
    }
}

class MyClass2 {

}
