package ch8.linkedlist;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

import ch8.list.List;

public class SimpleLinkedList<T> implements List<T> {
    private Node<T> first = null;

    public SimpleLinkedList() {
    }

    public SimpleLinkedList(Collection<? extends T> c) {
        if (c.size() > 0) {
            boolean isInited = false;
            Node<T> currentNode = null;
            for (T t : c) {
                if (!isInited) {
                    first = new Node<T>(t);
                    currentNode = first;
                    isInited = true;
                    continue;
                }
                Node<T> newNode = new Node<T>(t);
                currentNode.link(newNode);
                currentNode = newNode;
            }
        }
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current;

            @Override
            public boolean hasNext() {
                if (first == null) {
                    return false;
                } else if (current == null) {
                    return true;
                } else {
                    return current.hasNext();
                }
            }

            @Override
            public T next() {
                if (first == null) {
                    return null;
                } else if (current == null) {
                    current = first;
                    return current.getData();
                } else {
                    current = current.getNext();
                    return current.getData();
                }
            }

        };
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(T e) {
        if (first == null) {
            first = new Node<T>(e);
        } else {
            Node<T> newNode = new Node<T>(e);
            Node<T> lastNode = getLastNode();
            lastNode.link(newNode);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
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
    public boolean addAll(int index, Collection<? extends T> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T set(int index, T element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void add(int index, T element) {
        // TODO Auto-generated method stub

    }

    @Override
    public T remove(int index) {
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
    public ListIterator<T> listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return null;
    }

    private Node<T> getLastNode() {
        if (first == null) {
            return first;
        }
        Node<T> current = first;
        while (true) {
            if (current.hasNext()) {
                current = current.getNext();
            } else {
                break;
            }
        }
        return current;
    }

    private class Node<T> {
        private Object data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return (T) data;
        }

        public void link(Node<T> next) {
            this.next = next;
        }

        public boolean hasNext() {
            return next != null;
        }

        public Node<T> getNext() {
            return next;
        }
    }

    public static void main(String[] args) {
        SimpleLinkedList<Integer> numbers = new SimpleLinkedList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        for (Integer integer : numbers) {
            System.out.print(integer + " ");
        }
        System.out.println();
        numbers = new SimpleLinkedList<>(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }));
        numbers.add(99);
        for (Integer integer : numbers) {
            System.out.print(integer + " ");
        }
    }
}
