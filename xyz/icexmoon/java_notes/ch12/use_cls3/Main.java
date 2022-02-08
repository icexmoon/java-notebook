package ch12.use_cls3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import util.Fmt;

class MyCls {
    public MyCls() {
    }

    public MyCls(int num) {
        Fmt.printf("MyCls(%d) is called.\n", num);
    }
}

public class Main {
    private static void printCls(Class cls) {
        System.out.println(cls.getName());
        System.out.println(cls.getSimpleName());
        System.out.println(cls.getCanonicalName());
    }

    private static Object createInstance(Class cls) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Constructor c;
        c = cls.getConstructor();
        return c.newInstance();
    }

    private static MyCls createMyCls(int num) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<MyCls> c = MyCls.class.getConstructor(int.class);
        return c.newInstance(num);
    }

    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException {
        printCls(MyCls.class);
        System.out.println(createInstance(MyCls.class));
        System.out.println(createMyCls(123));
    }
}
// ch12.use_cls2.MyCls
// MyCls
// ch12.use_cls2.MyCls
// ch12.use_cls2.MyCls@24d46ca6
// MyCls(123) is called.
// ch12.use_cls3.MyCls@6d311334