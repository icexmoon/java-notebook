package ch16.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import ch15.test2.ArrayFiller;
import ch15.test2.CommonGenerator;
import ch15.test2.Generator;
import ch15.test2.RandomGenerator;
import ch16.generator.ListFiller;
import util.Fmt;

public class Main {
    public static void main(String[] args) {
        testCheckedXXX();
        testMaxMin();
        testIndexOf();
        testReplaceAll();
        testReverse();
        testReverseOrder();
        testRotate();
        testShuffle();
        testSort();
        testCopy();
        testSeap();
        testFill();
        testNCopies();
        testDisJoin();
        testFrequency();
        testEmptyXXX();
        testSingletonXXX();
    }

    private static void testSingletonXXX() {
        Set<Integer> set = Collections.singleton(Integer.valueOf(99));
        List<Integer> list = Collections.singletonList(Integer.valueOf(99));
        Map<Integer, String> map = Collections.singletonMap(99, "hello");
        System.out.println(set);
        System.out.println(list);
        System.out.println(map);
        // [99]
        // [99]
        // {99=hello}
    }

    private static void testEmptyXXX() {
        List<Integer> emptyList = Collections.emptyList();
        Set<Integer> emptySet = Collections.emptySet();
        Map<Integer, String> emptyMap = Collections.emptyMap();
        try {
            emptyList.add(1);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            emptySet.add(1);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            emptyMap.put(1, "hello");
        } catch (Exception e) {
            System.out.println(e);
        }
        // java.lang.UnsupportedOperationException
        // java.lang.UnsupportedOperationException
        // java.lang.UnsupportedOperationException
    }

    private static void testFrequency() {
        List<Integer> nums = ListFiller.getList(new RandomGenerator.IntGenerator(10), 10);
        Integer target = nums.get(0);
        int times = Collections.frequency(nums, target);
        System.out.println(nums);
        Fmt.printf("find %s in list %d times\n", target, times);
        // [3, 0, 1, 3, 9, 0, 7, 4, 2, 0]
        // find 3 in list 2 times
    }

    private static void testDisJoin() {
        List<Integer> list1 = new LinkedList<>(Arrays.asList(1, 2, 3));
        List<Integer> list2 = new LinkedList<>(Arrays.asList(4, 5, 6));
        System.out.println(Collections.disjoint(list1, list2));
        list1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        list2 = new LinkedList<>(Arrays.asList(2, 3, 4));
        System.out.println(Collections.disjoint(list1, list2));
        // true
        // false
    }

    private static void testNCopies() {
        List<Integer> list = Collections.nCopies(10, Integer.valueOf(99));
        System.out.println(list);
        try {
            list.set(0, 0);
        } catch (Exception e) {
            System.out.println(e);
        }
        // [99, 99, 99, 99, 99, 99, 99, 99, 99, 99]
        // java.lang.UnsupportedOperationException
    }

    private static void testFill() {
        List<Integer> list = ListFiller.getList(new CommonGenerator.IntGenerator(), 10);
        System.out.println(list);
        Collections.fill(list, 99);
        System.out.println(list);
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        // [99, 99, 99, 99, 99, 99, 99, 99, 99, 99]
    }

    private static void testSeap() {
        List<Integer> list = new ArrayList<>();
        ListFiller.fill(list, new CommonGenerator.IntGenerator(), 10);
        System.out.println(list);
        Collections.swap(list, 3, 6);
        System.out.println(list);
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        // [0, 1, 2, 6, 4, 5, 3, 7, 8, 9]
    }

    private static void testCopy() {
        List<Integer> source = new ArrayList<>();
        List<Integer> target = new ArrayList<>();
        ListFiller.fill(source, new RandomGenerator.IntGenerator(), 5);
        ListFiller.fillBySame(target, null, 10);
        System.out.println(source);
        System.out.println(target);
        Collections.copy(target, source);
        System.out.println(source);
        System.out.println(target);
        // [96, 84, 79, 72, 69, 45, 44, 39, 27, 24]
        // [54, 27, 24, 62, 5]
        // [null, null, null, null, null, null, null, null, null, null]
        // [54, 27, 24, 62, 5]
        // [54, 27, 24, 62, 5, null, null, null, null, null]
    }

    private static void testSort() {
        List<Integer> list = new LinkedList<>();
        ListFiller.fill(list, new RandomGenerator.IntGenerator(), 10);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        // [70, 50, 18, 89, 82, 5, 61, 26, 83, 64]
        // [5, 18, 26, 50, 61, 64, 70, 82, 83, 89]
        // [89, 83, 82, 70, 64, 61, 50, 26, 18, 5]
    }

    private static void testShuffle() {
        List<Integer> list = new LinkedList<>();
        ListFiller.fill(list, new CommonGenerator.IntGenerator(), 10);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.shuffle(list, new Random(17));
        System.out.println(list);
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        // [6, 7, 2, 5, 0, 1, 3, 8, 4, 9]
        // [9, 2, 6, 8, 4, 0, 7, 1, 5, 3]
    }

    private static void testRotate() {
        List<Integer> list = new LinkedList<>();
        ListFiller.fill(list, new CommonGenerator.IntGenerator(), 10);
        System.out.println(list);
        Collections.rotate(list, 1);
        System.out.println(list);
        Collections.rotate(list, 3);
        System.out.println(list);
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        // [9, 0, 1, 2, 3, 4, 5, 6, 7, 8]
        // [6, 7, 8, 9, 0, 1, 2, 3, 4, 5]
    }

    private static void testReverseOrder() {
        List<String> list = new ArrayList<>(Arrays.asList("absdfdsfSDFNWER".split("")));
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        System.out.println(list);
        // [D, E, F, N, R, S, W, a, b, d, d, f, f, s, s]
        // [s, s, f, f, d, d, b, a, W, S, R, N, F, E, D]
        // [a, b, d, d, D, E, f, f, F, N, R, s, s, S, W]
        // [W, s, s, S, R, N, f, f, F, E, d, d, D, b, a]
    }

    private static void testReverse() {
        List<Integer> list = new ArrayList<>();
        ListFiller.fill(list, new CommonGenerator.IntGenerator(), 10);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        // [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
    }

    private static void testReplaceAll() {
        List<Integer> list = new ArrayList<>();
        ListFiller.fill(list, new CommonGenerator.IntGenerator(), 3);
        ListFiller.fill(list, new CommonGenerator.IntGenerator(), 6);
        System.out.println(list);
        Collections.replaceAll(list, 0, 99);
        System.out.println(list);
        // [0, 1, 2, 0, 1, 2, 3, 4, 5]
        // [99, 1, 2, 99, 1, 2, 3, 4, 5]
    }

    private static void testIndexOf() {
        Integer[] nums = new Integer[10];
        ArrayFiller.fill(nums, new CommonGenerator.IntGenerator());
        ArrayFiller.fillTail(nums, new CommonGenerator.IntGenerator(), 5);
        List<Integer> list1 = new ArrayList<>(Arrays.asList(nums));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(nums).subList(1, 3));
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(Collections.indexOfSubList(list1, list2));
        System.out.println(Collections.lastIndexOfSubList(list1, list2));
        // [0, 1, 2, 3, 4, 0, 1, 2, 3, 4]
        // [1, 2]
        // 1
        // 6
    }

    private static void testMaxMin() {
        List<Integer> list = new LinkedList<>();
        ListFiller.fill(list, new RandomGenerator.IntGenerator(), 10);
        System.out.println(list);
        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));
        System.out.println(Collections.max(list, Collections.reverseOrder()));
        // [5, 60, 36, 93, 52, 9, 87, 51, 92, 39]
        // 5
        // 93
        // 5
    }

    @SuppressWarnings("unchecked")
    private static void testCheckedXXX() {
        List list = new ArrayList<Integer>();
        list.add("string");
        List checkedList = Collections.checkedList(list, Integer.class);
        try {
            checkedList.add("string");
        } catch (ClassCastException e) {
            System.out.println(e);
            // java.lang.ClassCastException: Attempt to insert class java.lang.String
            // element into collection with element type class java.lang.Integer
        }
    }
}
