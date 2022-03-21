package ex1.hash;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import ch15.test2.Generator;
import ch15.test2.RandomGenerator;
import util.Fmt;

class Container<E> {
    private E[] contents;
    private Class<E> type;
    private int index = 0;

    @SuppressWarnings("unchecked")
    public Container(int size, Class<E> type) {
        contents = (E[]) Array.newInstance(type, size);
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    public void add(E item) {
        if (index >= contents.length) {
            // 容量不够，扩容
            E[] oldContents = contents;
            contents = (E[]) Array.newInstance(type, oldContents.length * 2);
            System.arraycopy(oldContents, 0, contents, 0, oldContents.length);
            add(item);
            return;
        }
        contents[index] = item;
        index++;
    }

    @Override
    public String toString() {
        return Arrays.toString(contents);
    }

    public int size() {
        return contents.length;
    }

    public E get(int index) {
        return contents[index];
    }

    public int find(E target) {
        for (int i = 0; i < contents.length; i++) {
            if (target.equals(contents[i])) {
                return i;
            }
        }
        return -1;
    }
}

public class Main {
    private static Random rand = new Random();

    public static void main(String[] args) {
        Container<Integer> container = new Container<>(5, Integer.class);
        test(container, new RandomGenerator.IntGenerator());
    }

    private static <E> void test(Container<E> container, Generator<E> gen) {
        for (int i = 0; i < 10; i++) {
            container.add(gen.next());
        }
        System.out.println(container);
        E find = container.get(rand.nextInt(container.size()));
        int index = container.find(find);
        System.out.println(Fmt.sprintf("find %s in index %d", find, index));
    }
}
// [58, 58, 70, 37, 80, 90, 80, 13, 64, 8]
// find 80 in index 4