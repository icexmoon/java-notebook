package ch13.array5;

import java.lang.reflect.Array;
import java.util.Arrays;

class SimpleList<T> {
    private T[] array;

    public SimpleList(Class<T> type, int size) {
        array = (T[]) Array.newInstance(type, size);
    }

    public void set(int index, T value) {
        array[index] = value;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] getArr() {
        return array;
    }
}

public class Main {
    public static void main(String[] args) {
        SimpleList<String> sl = new SimpleList(String.class, 5);
        sl.set(1, "hello");
        System.out.println(sl.get(1));
        String[] strings = sl.getArr();
        System.out.println(Arrays.toString(strings));
    }
}
// hello
// [null, hello, null, null, null]