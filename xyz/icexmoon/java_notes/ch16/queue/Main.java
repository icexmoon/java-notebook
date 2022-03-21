package ch16.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

import ch15.test2.CommonGenerator;
import ch15.test2.Generator;
import ch15.test2.RandomGenerator;

public class Main {
    public static void main(String[] args) {
        test(new LinkedList<Integer>(), new CommonGenerator.IntGenerator());
        test(new LinkedList<Character>(), new CommonGenerator.CharGenerator());
        test(new PriorityQueue<>(), new RandomGenerator.IntGenerator());
    }

    private static <T> void test(Queue<T> queue, Generator<T> gen) {
        for (int i = 0; i < 10; i++) {
            queue.add(gen.next());
        }
        do {
            T item = null;
            try {
                item = queue.remove();
            } catch (NoSuchElementException e) {
                break;
            }
            System.out.print(item + " ");
        } while (true);
        System.out.println();
    }
}
// 0 1 2 3 4 5 6 7 8 9
// a b c d e f g h i j
// 31 36 41 42 47 48 59 77 78 81