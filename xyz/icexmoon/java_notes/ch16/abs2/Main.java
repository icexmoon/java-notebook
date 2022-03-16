package ch16.abs2;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ch15.test2.CommonGenerator;
import ch15.test2.Generator;

class SampleMap<K, V> extends AbstractMap<K, V> {
    private int size;
    private Generator<K> kGen;
    private Generator<V> vGen;
    private Set<Entry<K, V>> entries = new HashSet<>();

    public SampleMap(Generator<K> kGen, Generator<V> vGen, int size) {
        this.kGen = kGen;
        this.vGen = vGen;
        if (size < 0) {
            size = 0;
        }
        this.size = size;
        for (int i = 0; i < size; i++) {
            entries.add(newEntry());
        }
    }

    public SampleMap(Generator<K> kGen, Generator<V> vGen) {
        this(kGen, vGen, 10);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return entries;
    }

    private Entry<K, V> newEntry() {
        return new Entry<K, V>() {

            @Override
            public K getKey() {
                return kGen.next();
            }

            @Override
            public V getValue() {
                return vGen.next();
            }

            @Override
            public V setValue(V value) {
                throw new UnsupportedOperationException();
            }

        };
    }

}

public class Main {
    public static void main(String[] args) {
        Map<Integer, Character> map = new SampleMap<Integer, Character>(new CommonGenerator.IntGenerator(),
                new CommonGenerator.CharGenerator());
        System.out.println(map);
    }
}
// {0=a, 1=b, 2=c, 3=d, 4=e, 5=f, 6=g, 7=h, 8=i, 9=j}
