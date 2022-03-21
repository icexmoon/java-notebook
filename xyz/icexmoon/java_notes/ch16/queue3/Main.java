package ch16.queue3;

import java.util.Deque;
import java.util.LinkedList;

import ch15.test2.CommonGenerator;
import ch15.test2.Generator;

public class Main {
    public static void main(String[] args) {
        test(new LinkedList<>(), new CommonGenerator.IntGenerator());
    }

    private static <T> void test(Deque<T> deque, Generator<T> gen) {
        fillDeque(deque, gen);
        while (deque.peekFirst() != null) {
            T item = deque.removeFirst();
            System.out.print(item + " ");
        }
        System.out.println();
        deque.clear();
        gen.reset();
        fillDeque(deque, gen);
        while (deque.peekLast() != null) {
            T item = deque.removeLast();
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static <T> void fillDeque(Deque<T> deque, Generator<T> gen) {
        for (int i = 0; i < 5; i++) {
            deque.addFirst(gen.next());
        }
        for (int i = 0; i < 5; i++) {
            deque.addLast(gen.next());
        }
    }
}
// 4 3 2 1 0 5 6 7 8 9 
// 9 8 7 6 5 0 1 2 3 4