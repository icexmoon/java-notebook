package ch13.array4;

import java.util.Arrays;

class SimpleList<T> {
    private Object[] array;

    public SimpleList(int size) {
        array = new Object[size];
    }

    public void set(int index, T value){
        array[index] = value;
    }

    public T get(int index){
        return (T)array[index];
    }

    public T[] getArr(){
        return (T[])array;
    }
}

public class Main {
    public static void main(String[] args) {
        SimpleList<String> sl = new SimpleList(5);
        sl.set(1, "hello");
        System.out.println(sl.get(1));
        String[] strings = sl.getArr();
        System.out.println(Arrays.toString(strings));
    }
}
// hello
// Exception in thread "main" java.lang.ClassCastException: class [Ljava.lang.Object; cannot be cast to class [Ljava.lang.String; ([Ljava.lang.Object; and [Ljava.lang.String; are in module java.base of loader 'bootstrap')
//         at ch13.array3.Main.main(Main.java:30)
