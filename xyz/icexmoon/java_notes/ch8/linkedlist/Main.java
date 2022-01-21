package ch8.linkedlist;

import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        Collections.addAll(ll, 1, 2, 3, 4, 5);
        System.out.println(ll.getFirst());
        System.out.println(ll.element());
        System.out.println(ll.peek());
        // 1
        // 1
        // 1
    }
}
