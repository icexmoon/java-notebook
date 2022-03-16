package ch16.generator;

import java.util.ArrayList;
import java.util.List;

import ch15.test2.CommonGenerator;
import ch15.test2.Generator;

public class ListFiller {
    public static <T> List<T> fill(List<T> list, Generator<T> gen, int num) {
        list.addAll(getList(gen, num));
        return list;
    }

    public static <T> List<T> getList(Generator<T> gen, int num) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(gen.next());
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        fill(nums, new CommonGenerator.IntGenerator(), 5);
        System.out.println(nums);
        List<Character> chars = new ArrayList<>(getList(new CommonGenerator.CharGenerator(), 5));
        System.out.println(chars);
        List<String> strings = new ArrayList<>();
        strings.addAll(getList(new CommonGenerator.StringGenerator(), 5));
        System.out.println(strings);
    }
}
// [0, 1, 2, 3, 4]
// [a, b, c, d, e]
// [abcde, fghij, klmno, pqrst, uvwxy]