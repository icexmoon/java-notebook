package ch12.proxy;

import java.util.Random;

import util.Fmt;

class OriginalClass {
    public void func1(int num) {
        Fmt.printf("OriginalClass.func1(%d) is called.\n", num);
    }
}

class OriginalClassProxy extends OriginalClass {
    private OriginalClass oc;

    public OriginalClassProxy(OriginalClass oc) {
        this.oc = oc;
    }

    @Override
    public void func1(int num) {
        Fmt.printf("OriginalClassProxy.func1(%d) is called.\n", num);
        oc.func1(num);
    }
}

public class Main {
    private static void testOriginalClass(OriginalClass oc, int num) {
        oc.func1(num);
    }

    public static void main(String[] args) {
        OriginalClass oc = new OriginalClass();
        Random rand = new Random();
        testOriginalClass(oc, rand.nextInt(100));
        testOriginalClass(new OriginalClassProxy(oc), rand.nextInt(100));
    }
}
// OriginalClass.func1(90) is called.
// OriginalClassProxy.func1(5) is called.
// OriginalClass.func1(5) is called.