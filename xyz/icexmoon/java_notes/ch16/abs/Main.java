package ch16.abs;

import java.util.AbstractList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch15.test2.CommonGenerator;
import ch15.test2.Generator;

class SampleList<E> extends AbstractList<E> {
    private final int size;
    private Generator<E> gen;
    private Map<Integer, E> items = new HashMap<>();

    public SampleList(Generator<E> gen) {
        this(gen, 10);
    }

    public SampleList(Generator<E> gen, int size) {
        this.gen = gen;
        if (size < 0) {
            size = 0;
        }
        this.size = size;
    }

    @Override
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (!items.containsKey(index)) {
            E item = gen.next();
            items.put(index, item);
        }
        return items.get(index);
    }

    @Override
    public int size() {
        return size;
    }

}

public class Main {
    public static void main(String[] args) {
        List<Integer> sl = new SampleList<>(new CommonGenerator.IntGenerator());
        System.out.println(sl);
    }
}
// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]