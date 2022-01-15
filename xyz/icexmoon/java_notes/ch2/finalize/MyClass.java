package ch2.finalize;

public class MyClass {
    public MyClass() {
        System.out.println("MyClass is created.");
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("MyClass is finalized.");
        super.finalize();
    }
    public static void main(String[] args) {
        MyClass mc = new MyClass();
        mc = null;
        System.gc();
        // MyClass is created.
        // MyClass is finalized.
    }
}
