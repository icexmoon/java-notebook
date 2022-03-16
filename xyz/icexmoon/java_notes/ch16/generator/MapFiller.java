package ch16.generator;

import java.util.LinkedHashMap;
import java.util.Map;

import ch15.test2.CommonGenerator;
import ch15.test2.Generator;

public class MapFiller {
    public static class Entry<K, V> {
        public final K key;
        public final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static <K, V> Map<K, V> fill(Map<K, V> map, Generator<Entry<K, V>> gen, int num) {
        for (int i = 0; i < num; i++) {
            Entry<K, V> entry = gen.next();
            map.put(entry.key, entry.value);
        }
        return map;
    }

    public static <K, V> Map<K, V> fill(Map<K, V> map, Generator<K> keyGen, Generator<V> valueGen, int num) {
        for (int i = 0; i < num; i++) {
            map.put(keyGen.next(), valueGen.next());
        }
        return map;
    }

    public static <K, V> Map<K, V> getMap(Generator<Entry<K, V>> gen, int num) {
        Map<K, V> map = new LinkedHashMap<>();
        fill(map, gen, num);
        return map;
    }

    public static <K, V> Map<K, V> getMap(Generator<K> kGen, Generator<V> vGen, int num) {
        Map<K, V> map = new LinkedHashMap<>();
        fill(map, kGen, vGen, num);
        return map;
    }

    public static void main(String[] args) {
        Map<Integer, Character> map = getMap(new CommonGenerator.IntGenerator(), new CommonGenerator.CharGenerator(),
                5);
        System.out.println(map);
    }
}
// {0=a, 1=b, 2=c, 3=d, 4=e}
