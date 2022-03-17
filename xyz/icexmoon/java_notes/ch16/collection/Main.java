package ch16.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

class MyCollection<E> implements Collection<E> {
    private E[] items;

    public MyCollection(E[] arr) {
        items = arr;
    }

    @Override
    public int size() {
        return items.length;
    }

    @Override
    public boolean isEmpty() {
        return items.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (E item : items) {
            if (item.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = -1;

            @Override
            public boolean hasNext() {
                return index < items.length - 1;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException();
                }
                index++;
                return items[index];
            }

        };
    }

    @Override
    public Object[] toArray() {
        return items;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        return (T[]) items;
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object target : c) {
            if (!contains(target)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

}

public class Main {
    public static void main(String[] args) {
        String[] arr = "a b c d e".split(" ");
        Collection<String> collection = new MyCollection<>(arr);
        for (String item : collection) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println(collection.contains("a"));
        System.out.println(collection.containsAll(Arrays.asList("a", "b", "c")));
        System.out.println(collection.contains("g"));
        System.out.println(collection.containsAll(Arrays.asList("a", "z")));
    }
}
// a b c d e
// true
// true
// false
// false