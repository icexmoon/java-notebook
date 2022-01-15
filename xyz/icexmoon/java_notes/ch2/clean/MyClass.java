package ch2.clean;

import java.lang.ref.Cleaner;
import java.util.LinkedList;
import java.util.List;

public class MyClass {
    private int number;

    public MyClass(int number) {
        this.number = number;
        System.out.println("MyClass(" + this.number + ") is build.");
    }

    @Override
    public String toString() {
        return "MyClass(" + this.number + ")";
    }

    public static void main(String[] args) {
        Cleaner cleaner = Cleaner.create();
        List<MyClass> mcList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            MyClass mc = new MyClass(i);
            mcList.add(mc);
            String mcName = mc.toString();
            cleaner.register(mc, new Runnable() {
                @Override
                public void run() {
                    System.out.println(mcName + " is destructed.");
                }
            });
        }
        mcList.clear();
        System.gc();
    }
}
// MyClass(0) is build.
// MyClass(1) is build.
// MyClass(2) is build.
// MyClass(3) is build.
// MyClass(4) is build.
// MyClass(5) is build.
// MyClass(6) is build.
// MyClass(7) is build.
// MyClass(8) is build.
// MyClass(9) is build.
// MyClass(6) is destructed.
// MyClass(9) is destructed.
// MyClass(8) is destructed.
// MyClass(7) is destructed.
// MyClass(5) is destructed.
// MyClass(4) is destructed.
// MyClass(3) is destructed.
// MyClass(2) is destructed.
// MyClass(1) is destructed.
// MyClass(0) is destructed.
