package ex1.hash3;

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
        if (index == 0) {
            // 空数组，直接插入
            contents[index] = item;
            // index++;
        } else {
            // 通过二分查找获取新元素应当插入的位置
            int insertIndex = Arrays.binarySearch(contents, 0, index, item);
            if (insertIndex < 0) {
                // 没有重复元素，转换插入点
                insertIndex = Math.abs(insertIndex) - 1;
            }
            if (insertIndex >= index) {
                // 插入位置是数组尾部，直接插入
                contents[index] = item;
            } else {
                // 插入点之后的元素后移
                for (int i = index; i > insertIndex; i--) {
                    contents[i] = contents[i - 1];
                }
                contents[insertIndex] = item;
            }
        }
        index++;
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
        test(container, new RandomGenerator.IntGenerator(10));
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