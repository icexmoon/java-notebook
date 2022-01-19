package ch7.func_inner;

public class Main {
    public static void main(String[] args) {
        class LocalInnerClass{
            @Override
            public String toString() {
                return this.getClass().getName();
            }
        }
        LocalInnerClass lic = new LocalInnerClass();
        System.out.println(lic);
        // ch7.func_inner.Main$1LocalInnerClass
    }
}
