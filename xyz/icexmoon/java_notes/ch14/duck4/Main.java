package ch14.duck4;

import java.util.ArrayList;
import java.util.List;

import util.Fmt;

interface Addable<T> {
    void add(T item);

    void clear();
}

class Handler<T> implements Addable<T> {
    private T content;

    @Override
    public void add(T item) {
        content = item;
    }

    @Override
    public void clear() {
        content = null;
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Handler(%s)", content);
    }

}

class Query<T> implements Addable<T> {
    private List<T> list = new ArrayList<>();

    @Override
    public void add(T item) {
        list.add(item);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Query(%s)", list);
    }
}

class OldHandler<T> {
    private T content;

    public void set(T content) {
        this.content = content;
    }

    public void clear() {
        this.content = null;
    }

    @Override
    public String toString() {
        return Fmt.sprintf("OldHandler(%s)", content);
    }
}

class OldHandlerAdapter<T> implements Addable<T>{
    private OldHandler<T> oldHandler;
    public OldHandlerAdapter(OldHandler<T> oldHandler){
        this.oldHandler = oldHandler;
    }
    @Override
    public void add(T item) {
        this.oldHandler.set(item);
    }
    @Override
    public void clear() {
        this.oldHandler.clear();
    }
    @Override
    public String toString() {
        return oldHandler.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        test(new Handler());
        test(new Query());
        test(new OldHandlerAdapter(new OldHandler()));
    }

    private static void test(Addable<Integer> addable) {
        addable.clear();
        for (int i = 0; i < 10; i++) {
            addable.add(i);
        }
        System.out.println(addable);
    }
}
// Handler(9)
// Query([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
// OldHandler(9)