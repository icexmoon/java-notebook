package ch9.foreach2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import ch8.collection.Collection;

interface MyIterator<T> extends Iterable<T>, Iterator<T> {
    @Override
    default Iterator<T> iterator() {
        return this;
    }
}

class MyArrayList<T> implements Iterable<T> {
    private List<T> contents = new ArrayList<>();

    public MyArrayList(Collection<? extends T> c) {
        for (T t : c) {
            contents.add(t);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>() {
            private Iterator<T> iterator = contents.iterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                return iterator.next();
            }

        };
    }

}

public class Main {
    public static void main(String[] args) {
        // MyArrayList<Integer> mal = new MyArrayList<>(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }));
    }
}
