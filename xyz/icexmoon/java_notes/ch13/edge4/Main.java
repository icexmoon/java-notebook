package ch13.edge4;

class GenericHolder<T> {
    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

}

public class Main {
    public static void main(String[] args) {
        GenericHolder<String> gh = new GenericHolder<>();
        gh.setContent("Hello World!");
        String msg = gh.getContent();
        System.out.println(msg);
    }
}
