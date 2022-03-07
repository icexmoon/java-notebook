package ch13.type_param5;

class GenericBase<T> {
    private T element;

    public void set(T element) {
        this.element = element;
    }

    public T get() {
        return element;
    }
}

class GenericSub1<T> extends GenericBase<T> {
}

class GenericSub2 extends GenericBase {
}

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        GenericSub2 gs = new GenericSub2();
        Object obj = gs.get();
        gs.set(obj);
    }
}
