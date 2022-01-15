package ch2.reference;

public class Recycle {
    Recycle r;

    private static void createRecycle() {
        Recycle r1 = new Recycle();
        Recycle r2 = new Recycle();
        r1.r = r2;
        r2.r = r1;
    }

    public static void main(String[] args) {
        createRecycle();
    }
}
