package ch8.arraylist3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

import ch8.list.List;

public class SimpleArrayList<E> implements List<E> {
    private static Object[] EMPTY_ARRAY = new Object[0];
    private Object[] array;
    private int size;
    private int cap;

    public SimpleArrayList() {
        array = EMPTY_ARRAY;
    }

    public SimpleArrayList(int cap) {
        array = new Object[cap];
        this.cap = cap;
    }

    public SimpleArrayList(Collection<? extends E> c) {
        Object[] newArray = c.toArray();
        if (newArray.length > 0) {
            size = newArray.length;
            cap = newArray.length;
            if (c.getClass() == ArrayList.class) {
                array = newArray;
            } else {
                array = Arrays.copyOf(newArray, newArray.length, Object[].class);
            }
        } else {
            array = EMPTY_ARRAY;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int cursor = -1;

            @Override
            public boolean hasNext() {
                if (cursor + 1 < size) {
                    return true;
                }
                return false;
            }

            @Override
            public E next() {
                cursor++;
                return (E) array[cursor];
            }

        };
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] toArray(Object[] a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(Object e) {
        if (cap > size) {
            array[size] = e;
            size++;
        } else if (size == 0) {
            // 初始一次增加1个容量
            int initCap = 1;
            array = new Object[initCap];
            array[0] = e;
            cap = initCap;
            size = 1;
        } else {
            // 一次性扩容一倍容量
            int newSize = size + 1;
            int newCap = cap * 2;
            System.out.println("do array extends,new cap is " + newCap);
            Object[] newArray = new Object[newCap];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            newArray[array.length] = e;
            array = newArray;
            cap = newCap;
            size = newSize;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean addAll(int index, Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E get(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void add(int index, Object element) {
        // TODO Auto-generated method stub

    }

    @Override
    public E remove(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int indexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return null;
    }

    public static void main(String[] args) {
        SimpleArrayList<Integer> sal = new SimpleArrayList<>();
        fillSimpleArrayList(sal);
        printSimpleArrayList(sal);
        sal = new SimpleArrayList<>(10);
        fillSimpleArrayList(sal);
        printSimpleArrayList(sal);
        sal = new SimpleArrayList<>(Arrays.asList(new Integer[]{1,2,3,4,5}));
        fillSimpleArrayList(sal);
        printSimpleArrayList(sal);
        // do array extends,new cap is 2
        // do array extends,new cap is 4
        // do array extends,new cap is 8
        // do array extends,new cap is 16
        // 0 1 2 3 4 5 6 7 8 9
        // 0 1 2 3 4 5 6 7 8 9
        // do array extends,new cap is 10
        // do array extends,new cap is 20
        // 1 2 3 4 5 0 1 2 3 4 5 6 7 8 9
    }

    private static void fillSimpleArrayList(SimpleArrayList<Integer> sal) {
        for (int i = 0; i < 10; i++) {
            sal.add(i);
        }
    }

    private static void printSimpleArrayList(SimpleArrayList sal) {
        for (Object object : sal) {
            System.out.print(object + " ");
        }
        System.out.println();
    }

}
