package ch13.compensation2;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

class GenericClass<T> {
    private final int SIZE = 10;
    private Class<T> type;

    public GenericClass(Class<T> type) {
        this.type = type;
    }

    public void f(T obj) {
        T instance = null;
        try {
            instance = type.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            throw new RuntimeException(e);
        }
        System.out.println(instance);
        if (type.isInstance(obj)) {
            System.out.println("true");
        }
        T[] arr = (T[]) Array.newInstance(type, SIZE);
        System.out.println(Arrays.toString(arr));
    }
}

public class Main {
    public static void main(String[] args) {
        GenericClass<String> gc = new GenericClass<>(String.class);
        gc.f("hello");
    }
}

// true
// [null, null, null, null, null, null, null, null, null, null]
