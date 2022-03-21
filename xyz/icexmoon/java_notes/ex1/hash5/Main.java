package ex1.hash5;

import java.lang.reflect.Array;
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

    @SuppressWarnings("unchecked")
    public Container(int size, Class<E> type) {
        contents = (List<E>[]) Array.newInstance(List.class, size);
        this.type = type;
    }

    public void add(E item) {
        int hash = item.intValue() % contents.length;
        if (contents[hash] == null) {
            contents[hash] = new LinkedList<>();
        }
        contents[hash].add(item);
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
        int hash = target.intValue() % contents.length;
        return hash;
    }
}

public class Main {
    private static Random rand = new Random();

    public static void main(String[] args) {
        Container<Integer> container = new Container<>(10, Integer.class);
        test(container, new RandomGenerator.IntGenerator(1000));
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
// [null, [891, 731, 501], [982, 902, 352], [563], null, [805], null, [747], null, [569]]
// find 747 in index 7