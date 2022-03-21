package ex1.hash4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import ch15.test2.Generator;
import ch15.test2.RandomGenerator;
import util.Fmt;

class Container<E extends Integer> {
    private List<E>[] contents;
    private Class<E> type;
    // private int index = 0;

    @SuppressWarnings("unchecked")
    public Container(int size, Class<E> type) {
        contents = (List<E>[]) Array.newInstance(List.class, size);
        this.type = type;
    }

    public void add(E item) {
        if (item.intValue() >= contents.length) {
            throw new IndexOutOfBoundsException();
        }
        if (contents[item] == null) {
            contents[item] = new LinkedList<>();
        }
        contents[item].add(item);
    }

    @Override
    public String toString() {
        return Arrays.toString(contents);
    }

    public int size() {
        return contents.length;
    }

    public E get(int index) {
        if (contents[index] == null) {
            return null;
        }
        return contents[index].get(0);
    }

    public int find(E target) {
        return target.intValue();
    }
}

public class Main {
    private static Random rand = new Random();

    public static void main(String[] args) {
        final int MAX = 10;
        Container<Integer> container = new Container<>(MAX, Integer.class);
        test(container, new RandomGenerator.IntGenerator(MAX));
    }

    private static <E extends Integer> void test(Container<E> container, Generator<E> gen) {
        for (int i = 0; i < 10; i++) {
            container.add(gen.next());
        }
        System.out.println(container);
        E find = null;
        do {
            find = container.get(rand.nextInt(container.size()));
            if (find != null) {
                break;
            }
        } while (true);
        int index = container.find(find);
        System.out.println(Fmt.sprintf("find %s in index %d", find, index));
    }
}
// [[0], [1], [2, 2], null, [4], null, null, [7], [8, 8, 8], [9]]
// find 7 in index 7