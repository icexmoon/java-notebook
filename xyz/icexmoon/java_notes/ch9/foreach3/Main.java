package ch9.foreach3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {
    private static void foreachIterator(Iterator iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();
    }

    private static void foreachIterable(Iterable iterable) {
        for (Object object : iterable) {
            System.out.print(object + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6);
        foreachIterable(list);
        foreachIterator(list.iterator());
        // 1, 2, 3, 4, 5, 6,
        // 1, 2, 3, 4, 5, 6,
        Integer[] array = new Integer[] { 1, 2, 3 };
        // The method foreachIterable(Iterable) in the type Main is not applicable for
        // the arguments (Integer[])
        // foreachIterable(array);
    }
}
