package ch16.abs5;

import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ArrayListAdapter<T> extends AbstractList<T> {
    T[][] arr;
    int vector;

    public ArrayListAdapter(T[][] arr, int vector) {
        this.arr = arr;
        this.vector = vector;
    }

    @Override
    public T get(int index) {
        if (index >= arr.length) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index][vector];
    }

    @Override
    public int size() {
        return arr.length;
    }

}

class ArrayMapAdapter<T> extends AbstractMap<T, T> {
    private T[][] arr;

    private class InnerEntry implements Entry<T, T> {
        private int index = -1;

        @Override
        public T getKey() {
            return arr[index][0];
        }

        @Override
        public T getValue() {
            return arr[index][1];
        }

        @Override
        public T setValue(T value) {
            throw new UnsupportedOperationException();
        }

    }

    private class InnerSet extends LinkedHashSet<Entry<T, T>> {

        @Override
        public Iterator<Entry<T, T>> iterator() {
            return new Iterator<Map.Entry<T, T>>() {
                private InnerEntry ie = new InnerEntry();

                @Override
                public boolean hasNext() {
                    if (ie.index >= arr.length - 1) {
                        return false;
                    }
                    return true;
                }

                @Override
                public Entry<T, T> next() {
                    ie.index++;
                    return ie;
                }

            };
        }
    }

    public ArrayMapAdapter(T[][] arr) {
        this.arr = arr;
    }

    @Override
    public Set<Entry<T, T>> entrySet() {
        return new InnerSet();
    }

}

public class Main {
    public static void main(String[] args) {
        String[][] info = { { "Han Meimei", "19" }, { "Li Lei", "20" }, { "Jack Chen", "15" },
                { "Brus Lee", "11" } };
        Map<String, String> map = new ArrayMapAdapter<>(info);
        System.out.println(map);
        List<String> names = new ArrayListAdapter<String>(info, 0);
        List<String> ages = new ArrayListAdapter<String>(info, 1);
        System.out.println(names);
        System.out.println(ages);
    }
}
