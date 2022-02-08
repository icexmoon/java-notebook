package ch12.cls_init2;

class MyCls1 {
    static public int num = 47;
    static {
        System.out.println("MyCls1 is inited.");
    }
}

class MyCls2 {
    public static int num = 47;
    static {
        System.out.println("MyCls2 is inited.");
    }
}

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class classRef1 = Class.forName("ch12.cls_init2.MyCls1");
        System.out.println("class1 ref is get.");
        Class classRef2 = MyCls2.class;
        System.out.println("class2 ref is get.");
        System.out.println(MyCls2.num);
    }
}
// MyCls1 is inited.
// class1 ref is get.
// class2 ref is get.
// MyCls2 is inited.
// 47