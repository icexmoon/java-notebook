package ch14.mixin3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

interface Baseable {
    public void setObj(Object obj);

    public Object getObj();
}

interface Countable {
    public void count();

    public int getId();
}

class Base implements Baseable {

    private Object obj;

    @Override
    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object getObj() {
        return this.obj;
    }

}

class Counter implements Countable {
    private static int count;
    private int id;

    @Override
    public void count() {
        id = ++count;
    }

    @Override
    public int getId() {
        return id;
    }
}

class TwoTuple<A, B> {
    public final A a;
    public final B b;

    public TwoTuple(A a, B b) {
        this.a = a;
        this.b = b;
    }
}

class Mixin {
    Map<String, Object> callables = new HashMap<>();

    private Mixin(TwoTuple<Object, Class<?>>... tuples) {
        for (TwoTuple<Object, Class<?>> tuple : tuples) {
            addCallable(tuple.a, tuple.b);
        }
    }

    private void addCallable(Object obj, Class<?> cls) {
        for (Method method : cls.getMethods()) {
            if (!callables.containsKey(method.getName())) {
                callables.put(method.getName(), obj);
            }
        }
    }

    public static Object newInstance(TwoTuple<Object, Class<?>>... tuples) {
        Class<?>[] interfaces = new Class<?>[tuples.length];
        int i = 0;
        Mixin mixin = new Mixin(tuples);
        for (TwoTuple<Object, Class<?>> tuple : tuples) {
            interfaces[i] = tuple.b;
            i++;
        }
        return Proxy.newProxyInstance(interfaces[0].getClassLoader(), interfaces, mixin.getInvocationHandler());
    }

    private InvocationHandler getInvocationHandler() {
        return new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (callables.containsKey(method.getName())) {
                    return method.invoke(callables.get(method.getName()), args);
                }
                return null;
            }
        };
    }
}

public class Main {
    public static void main(String[] args) {
        Object proxy = Mixin.newInstance(new TwoTuple<>(new Base(), Baseable.class),
                new TwoTuple<>(new Counter(), Countable.class));
        Baseable baseable = (Baseable) proxy;
        baseable.setObj("hello");
        System.out.println(baseable.getObj());
        Countable countable = (Countable) proxy;
        countable.count();
        System.out.println(countable.getId());
    }
}
