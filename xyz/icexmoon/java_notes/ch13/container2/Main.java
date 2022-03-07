package ch13.container2;

import util.Fmt;

class SimpleContainer<T> {
    private T content;

    public SimpleContainer(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return Fmt.sprintf("SimpleContainer(%s)", content);
    }
}

public class Main {
    public static void main(String[] args) {
        SimpleContainer<Integer> sc = new SimpleContainer<>(17);
        System.out.println(sc);
        sc.setContent(22);
        System.out.println(sc);
        // sc.setContent("hello");
        // System.out.println(sc);
        // The method setContent(Integer) in the type SimpleContainer<Integer> is not
        // applicable for the arguments (String)
    }
}
// SimpleContainer(17)
// SimpleContainer(22)