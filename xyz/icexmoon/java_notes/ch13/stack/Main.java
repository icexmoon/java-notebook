package ch13.stack;

import util.Fmt;

class MyStack<T> {
    private static class Node<T> {
        private T content;
        private Node<T> next;

        public Node(T content, Node<T> next) {
            this.content = content;
            this.next = next;
        }
    }

    private Node<T> top = new Node<T>(null, null);

    public boolean empty() {
        if (top.content == null && top.next == null) {
            return true;
        }
        return false;
    }

    public T pop() {
        if (empty()) {
            return null;
        }
        T result = top.content;
        top = top.next;
        return result;
    }

    public void push(T item) {
        Node<T> newItem = new Node<>(item, null);
        newItem.next = top;
        top = newItem;
    }
}

public class Main {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<String>();
        String[] words = "Hello world, how are you!".split("( |, ?|! ?)");
        for (String word : words) {
            stack.push(word);
        }
        while (!stack.empty()) {
            Fmt.printf("%s ", stack.pop());
        }
    }
}
// you are how world Hello