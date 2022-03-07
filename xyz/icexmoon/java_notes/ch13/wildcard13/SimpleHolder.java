package ch13.wildcard13;

public class SimpleHolder<T> {
    private T content;

    public SimpleHolder(T content) {
        this.content = content;
    }

    public void set(T content) {
        this.content = content;
    }

    public T get() {
        return this.content;
    }
}
