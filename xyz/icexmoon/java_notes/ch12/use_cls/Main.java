package ch12.use_cls;

class MyCls {
}

public class Main {
    private static void printCls(Class cls) {
        System.out.println(cls.getName());
        System.out.println(cls.getSimpleName());
        System.out.println(cls.getCanonicalName());
    }

    public static void main(String[] args) {
        printCls(MyCls.class);
    }
}
// ch12.use_cls.MyCls
// MyCls
// ch12.use_cls.MyCls
