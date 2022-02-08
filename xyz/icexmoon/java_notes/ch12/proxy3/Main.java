package ch12.proxy3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

import util.Fmt;

interface OriginalInterface {
    void func1(int num);
}

class OriginalClass implements OriginalInterface {
    public void func1(int num) {
        Fmt.printf("OriginalClass.func1(%d) is called.\n", num);
    }

    public InvocationHandler getInvocationHandler() {
        return new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                StringBuilder sb = new StringBuilder();
                for (Object arg : args) {
                    sb.append(arg.toString());
                    sb.append(", ");
                }
                if (sb.length() >= 2) {
                    sb.delete(sb.length() - 2, sb.length());
                }
                Fmt.printf("DynamicProxy.%s(%s) is called.\n", method.getName(), sb.toString());
                return method.invoke(OriginalClass.this, args);
            }

        };
    }
}

public class Main {
    private static void testOriginalClass(OriginalInterface oi, int num) {
        oi.func1(num);
    }

    public static void main(String[] args) {
        OriginalClass oc = new OriginalClass();
        Random rand = new Random();
        testOriginalClass(oc, rand.nextInt(100));
        OriginalInterface dynamicProxy = (OriginalInterface) Proxy.newProxyInstance(OriginalClass.class.getClassLoader(),
                new Class<?>[] { OriginalInterface.class },
                oc.getInvocationHandler());
        testOriginalClass(dynamicProxy, rand.nextInt(100));
    }
}
// OriginalClass.func1(64) is called.
// DynamicProxy.func1(15) is called.
// OriginalClass.func1(15) is called.