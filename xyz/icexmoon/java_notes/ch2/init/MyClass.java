package ch2.init;

public class MyClass {
    MyClass2 mc2;
    int intMember;
    String strMember;

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
