package ex1.map;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ch15.test2.Generator;
import ch15.test2.RandomGenerator;
import util.Fmt;

import java.util.Set;

class MyHashMap<K, V> implements Map<K, V> {
    private static class MapEntry<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public String toString() {
            return Fmt.sprintf("%s=%s", key, value);
        }

    }

    private List<Entry<K, V>>[] contents;

    @SuppressWarnings("unchecked")
    public MyHashMap(int cap) {
        if (cap < 1) {
            cap = 1;
        }
        contents = new List[cap];
    }

    @Override
    public int size() {
        int size = 0;
        for (List<Entry<K, V>> list : contents) {
            if (list != null) {
                size += list.size();
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        Entry<K, V> entry = getEntry(key);
        return entry != null;
    }

    @Override
    public boolean containsValue(Object value) {
        for (List<Entry<K, V>> list : contents) {
            if (list == null) {
                continue;
            }
            for (Entry<K, V> entry : list) {
                if (entry.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        Entry<K, V> entry = getEntry(key);
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        Entry<K, V> entry = getEntry(key);
        if (entry != null) {
            oldValue = entry.getValue();
            entry.setValue(value);
            return oldValue;
        }
        addEntry(key, value);
        return oldValue;
    }

    @Override
    public V remove(Object key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            return null;
        }
        V oldValue = entry.getValue();
        int index = getContentsIndex(key);
        contents[index].remove(entry);
        return oldValue;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        Arrays.fill(contents, null);
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Entry<K, V> entry : entrySet()) {
            keys.add(entry.getKey());
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        Set<V> values = new HashSet<>();
        for (Entry<K, V> entry : entrySet()) {
            values.add(entry.getValue());
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entries = new HashSet<>();
        for (List<Entry<K, V>> list : contents) {
            if (list != null) {
                entries.addAll(list);
            }
        }
        return entries;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (Entry<K, V> entry : entrySet()) {
            sb.append(entry.toString());
            sb.append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append("]");
        return sb.toString();
    }

    private int getContentsIndex(Object object) {
        int hashCode = object.hashCode();
        int index = Math.abs(hashCode) % contents.length;
        return index;
    }

    private Entry<K, V> getEntry(Object key) {
        int index = getContentsIndex(key);
        if (contents[index] == null) {
            return null;
        }
        for (Entry<K, V> entry : contents[index]) {
            if (entry.getKey().equals(key)) {
                return entry;
            }
        }
        return null;
    }

    private void addEntry(K key, V value) {
        int index = getContentsIndex(key);
        if (contents[index] == null) {
            contents[index] = new LinkedList<>();
        }
        contents[index].add(new MapEntry<>(key, value));
    }
}

public class Main {
    public static void main(String[] args) {
        test(new MyHashMap<Integer, String>(10), new RandomGenerator.IntGenerator(),
                new RandomGenerator.StringGenerator());
    }

    private static void test(Map<Integer, String> map, Generator<Integer> kGen, Generator<String> vGen) {
        for (int i = 0; i < 10; i++) {
            map.put(kGen.next(), vGen.next());
        }
        System.out.println(map);
        map.clear();
        map.put(1, "hello");
        map.put(1, "hello");
        System.out.println(map);
        map.put(1, "world");
        System.out.println(map);
        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue("world"));
    }
}
// [14=gcsmq,47=cltks,39=flvxy,95=abqfh,65=fponx,30=cizjh,45=wamrt,37=wlymv,36=dgpmh,63=nmmka]
// [1=hello]
// [1=world]
// true
// true