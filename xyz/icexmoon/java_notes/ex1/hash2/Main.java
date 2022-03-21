package ex1.hash2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
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
        // 对数组进行排序
        Arrays.sort(contents, 0, index);
    }

    @Override
    public String toString() {
        return Arrays.toString(contents);
    }

    public int size() {
        return index;
    }

    public E get(int index) {
        return contents[index];
    }

    public int find(E target) {
        // 使用二分查找
        return Arrays.binarySearch(contents, 0, index, target);
    }
}

public class Main {
    private static Random rand = new Random();

    public static void main(String[] args) {
        Container<Integer> container = new Container<>(5, Integer.class);
        test(container, new RandomGenerator.IntGenerator());
    }

    private static <E> void test(Container<E> container, Generator<E> gen) {
        for (int i = 0; i < 13; i++) {
            container.add(gen.next());
        }
        System.out.println(container);
        E find = container.get(rand.nextInt(container.size()));
        int index = container.find(find);
        System.out.println(Fmt.sprintf("find %s in index %d", find, index));
    }
}
// [7, 10, 25, 28, 36, 55, 55, 60, 65, 72, 78, 86, 99, null, null, null, null,
// null, null, null]
// find 78 in index 10