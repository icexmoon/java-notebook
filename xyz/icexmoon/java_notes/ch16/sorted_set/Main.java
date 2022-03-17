package ch16.sorted_set;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import ch15.test2.CommonGenerator;
import ch16.generator.ListFiller;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = ListFiller.getList(new CommonGenerator.IntGenerator(), 10);
        SortedSet<Integer> set = new TreeSet<>(list);
        System.out.println(set);
        System.out.println(set.first());
        System.out.println(set.last());
        System.out.println(set.subSet(Integer.valueOf(3), Integer.valueOf(7)));
        System.out.println(set.headSet(3));
        System.out.println(set.tailSet(6));
    }
}
// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
// 0
// 9
// [3, 4, 5, 6]
// [0, 1, 2]
// [6, 7, 8, 9]
