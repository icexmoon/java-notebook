package ch13.container;

import util.Fmt;

class SimpleContainer {
    private Object content;

    public SimpleContainer(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return Fmt.sprintf("SimpleContainer(%s)", content);
    }
}

public class Main {
    public static void main(String[] args) {
        SimpleContainer sc = new SimpleContainer(17);
        System.out.println(sc);
        sc.setContent("hello");
        System.out.println(sc);
    }
}
// SimpleContainer(17)
// SimpleContainer(hello)
