package ch8.list_iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        Collections.addAll(numbers, 1, 2, 3, 4, 5);
        System.out.println(numbers);
        ListIterator<Integer> li = numbers.listIterator();
        while (li.hasNext()) {
            if (li.nextIndex() == 2) {
                li.add(Integer.valueOf(99));
            }
            System.out.print(li.next() + " ");
        }
        System.out.println();
        while (li.hasPrevious()) {
            System.out.print(li.previous() + " ");
        }
        System.out.println();
        // [1, 2, 3, 4, 5]
        // 1 2 3 4 5 
        // 5 4 3 99 2 1
    }
}
