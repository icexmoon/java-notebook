package ch14.duck5;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import util.Fmt;

class Handler<T> {
    private T content;

    public void add(T item) {
        content = item;
    }

    public void clear() {
        content = null;
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Handler(%s)", content);
    }

}

class Query<T> {
    private List<T> list = new ArrayList<>();

    public void add(T item) {
        list.add(item);
    }

    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Query(%s)", list);
    }
}

public class Main {
    public static void main(String[] args) {
        test(new Handler<Integer>());
        test(new Query<Integer>());
    }

    private static void test(Object obj) {
        try {
            Method clearMethod = obj.getClass().getDeclaredMethod("clear");
            clearMethod.invoke(obj);
        } catch (NoSuchMethodException e) {
            ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            Method addMethod = obj.getClass().getDeclaredMethod("add", Object.class);
            for (int i = 0; i < 10; i++) {
                addMethod.invoke(obj, i);
            }
        } catch (NoSuchMethodException e) {
            ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(obj);
    }
}
// Handler(9)
// Query([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
