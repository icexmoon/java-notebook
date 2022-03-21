package ch16.sorted_map;

import java.util.SortedMap;
import java.util.TreeMap;

import ch15.test2.Generator;
import ch15.test2.RandomGenerator;

public class Main {
    public static void main(String[] args) {
        test(new TreeMap<>(), new RandomGenerator.IntGenerator(), new RandomGenerator.CharGenerator());
    }

    private static <V> void test(SortedMap<Integer, V> map, Generator<Integer> genKey, Generator<V> genVal) {
        for (int i = 0; i < 10; i++) {
            map.put(genKey.next(), genVal.next());
        }
        System.out.println(map);
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.subMap(25, 75));
        System.out.println(map.headMap(50));
        System.out.println(map.tailMap(50));
    }
}
// {32=z, 51=a, 60=j, 63=x, 71=s, 72=y, 79=s, 86=i}
// 32
// 86
// {32=z, 51=a, 60=j, 63=x, 71=s, 72=y}
// {32=z}
// {51=a, 60=j, 63=x, 71=s, 72=y, 79=s, 86=i}