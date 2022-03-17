package ch15.test2;

public interface Generator<T> {
    T next();

    default void reset() {
        throw new UnsupportedOperationException();
    }
}