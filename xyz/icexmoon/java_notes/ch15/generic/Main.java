package ch15.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // List<String>[] lists = new List<String>[5];
        // Cannot create a generic array of List<String>Java(16777751)
        List<String>[] lists;
        lists = (List<String>[]) new List[5];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<String>();
        }
        lists[1].add("hello");
        lists[2].add("world");
        System.out.println(Arrays.toString(lists));
    }
}
// [[], [hello], [world], [], []]
