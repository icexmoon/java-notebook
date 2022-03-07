package ch13.edge;

import java.lang.reflect.Array;
import java.util.Arrays;

class ArrayMaker<T> {
    private Class<T> type;

    public ArrayMaker(Class<T> type) {
        this.type = type;
    }

    public T[] create(int length) {
        return (T[]) Array.newInstance(type, length);
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayMaker<String> am = new ArrayMaker(String.class);
        String[] arr = am.create(5);
        System.out.println(Arrays.toString(arr));
        arr[0] = "hello";
        System.out.println(Arrays.toString(arr));
    }
}
// [null, null, null, null, null]
// [hello, null, null, null, null]