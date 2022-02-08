package ch12.use_cls2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class MyCls {
    public MyCls() {
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

    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException {
        printCls(MyCls.class);
        System.out.println(createInstance(MyCls.class));
    }
}
// ch12.use_cls2.MyCls
// MyCls
// ch12.use_cls2.MyCls
// ch12.use_cls2.MyCls@24d46ca6