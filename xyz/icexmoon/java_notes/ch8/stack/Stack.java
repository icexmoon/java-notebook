package ch8.stack;

import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> datas = new LinkedList<>();

    public T pop() {
        return datas.removeFirst();
    }

    public void push(T data) {
        datas.addFirst(data);
    }

    public T peek() {
        return datas.getFirst();
    }

    public boolean empty() {
        return datas.isEmpty();
    }

    @Override
    public String toString() {
        return datas.toString();
    }
}
