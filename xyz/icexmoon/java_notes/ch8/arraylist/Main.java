package ch8.arraylist;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

import ch8.list.List;

class MyArrayList implements List<Integer> {
    private Integer[] array;

    public MyArrayList(int... numbers) {
        array = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = numbers[i];
        }
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o instanceof Integer) {
            Integer target = (Integer) o;
            for (Integer i : array) {
                if (target.equals(i)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int cursor = -1;

            @Override
            public boolean hasNext() {
                return cursor + 1 < array.length;
            }

            @Override
            public Integer next() {
                cursor++;
                return array[cursor];
            }

        };
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(Integer e) {
        Integer[] newArray = new Integer[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = e;
        array = newArray;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(o)) {
                int removedIndex = i;
                Integer[] newArray = new Integer[array.length - 1];
                int newIndex = 0;
                for (int j = 0; j < array.length; j++) {
                    if (j != removedIndex) {
                        newArray[newIndex] = array[j];
                        newIndex++;
                    }
                }
                array = newArray;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int[] find = new int[array.length];
        for (Object o : c) {
            boolean matched = false;
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals(o)) {
                    if (find[i] != 0) {
                        continue;
                    } else {
                        find[i] = 1;
                        matched = true;
                        break;
                    }
                }
            }
            if (!matched) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Integer get(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer set(int index, Integer element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void add(int index, Integer element) {
        // TODO Auto-generated method stub

    }

    @Override
    public Integer remove(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ListIterator<Integer> listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}

public class Main {
    public static void main(String[] args) {
        MyArrayList mal = new MyArrayList(1, 2, 3, 4, 5, 6);
        System.out.println(mal);
        System.out.println(mal.size());
        System.out.println(mal.isEmpty());
        System.out.println(mal.contains(Integer.valueOf(3)));
        System.out.println(mal.contains(Integer.valueOf(10)));
        mal.add(100);
        System.out.println(mal);
        mal.remove(Integer.valueOf(100));
        System.out.println(mal);
        mal.remove(Integer.valueOf(3));
        System.out.println(mal);
        System.out.println(mal.remove(Integer.valueOf(99)));
        System.out.println(mal);
        mal.add(2);
        System.out.println(mal);
        System.out.println(mal.containsAll(Arrays.asList(new Integer[] { 1, 2, 2, 6 })));
    }
}
