package ch9.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import util.Fmt;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            queue.offer(i);
            Fmt.printf("%d in queue\n", i);
            Fmt.printf("now queue: %s\n", queue);
        }
        System.out.println("starting queue out operation.");
        do {
            try {
                int num = queue.remove();
                Fmt.printf("%d is queue out.\n", num);
                Fmt.printf("now queue: %s\n", queue);
            } catch (NoSuchElementException e) {
                break;
            }
        } while (true);
        System.out.println("queue is cleared.");
        // 1 in queue
        // now queue: [1]
        // 2 in queue
        // now queue: [1, 2]
        // 3 in queue
        // now queue: [1, 2, 3]
        // 4 in queue
        // now queue: [1, 2, 3, 4]
        // 5 in queue
        // now queue: [1, 2, 3, 4, 5]
        // 6 in queue
        // now queue: [1, 2, 3, 4, 5, 6]
        // 7 in queue
        // now queue: [1, 2, 3, 4, 5, 6, 7]
        // 8 in queue
        // now queue: [1, 2, 3, 4, 5, 6, 7, 8]
        // 9 in queue
        // now queue: [1, 2, 3, 4, 5, 6, 7, 8, 9]
        // 10 in queue
        // now queue: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        // starting queue out operation.
        // 1 is queue out.
        // now queue: [2, 3, 4, 5, 6, 7, 8, 9, 10]
        // 2 is queue out.
        // now queue: [3, 4, 5, 6, 7, 8, 9, 10]
        // 3 is queue out.
        // now queue: [4, 5, 6, 7, 8, 9, 10]
        // 4 is queue out.
        // now queue: [5, 6, 7, 8, 9, 10]
        // 5 is queue out.
        // now queue: [6, 7, 8, 9, 10]
        // 6 is queue out.
        // now queue: [7, 8, 9, 10]
        // 7 is queue out.
        // now queue: [8, 9, 10]
        // 8 is queue out.
        // now queue: [9, 10]
        // 9 is queue out.
        // now queue: [10]
        // 10 is queue out.
        // now queue: []
        // queue is cleared.
    }
}
