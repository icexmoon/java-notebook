package ch6.inner3;

class MyClass {
    private interface Printable {
        void print();
    }

    public static void passPrintable(Printable p) {
        p.print();
    }

    public static Printable getPrintable() {
        return new Printable() {

            @Override
            public void print() {
                System.out.println("This is a printable test.");
            }

        };
    }
}

public class Main {
    public static void main(String[] args) {
        // MyClass.Printable p = MyClass.getPrintable();
        // The type MyClass.Printable is not visible

        // Object o = MyClass.getPrintable();
        // MyClass.passPrintable(o);
        // The method passPrintable(MyClass.Printable) in the type MyClass is not applicable for the arguments (Object)
        
        MyClass.passPrintable(MyClass.getPrintable());
        // This is a printable test.
    }
}
