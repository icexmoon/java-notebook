package ch12.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

import util.Fmt;

class OriginalClass {
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
                Fmt.printf("DynamicProxy.%s(%s) is called.", method.getName(), sb.toString());
                return method.invoke(OriginalClass.this, args);
            }

        };
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
        OriginalClass dynamicProxy = (OriginalClass) Proxy.newProxyInstance(OriginalClass.class.getClassLoader(),
                new Class<?>[] {},
                oc.getInvocationHandler());
        testOriginalClass(dynamicProxy, rand.nextInt(100));
    }
}