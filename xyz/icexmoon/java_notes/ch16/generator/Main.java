package ch16.generator;

import java.util.Map;

import ch15.test2.CommonGenerator;
import ch15.test2.Generator;
import ch16.generator.MapFiller.Entry;

class IntCharGenerator implements Generator<MapFiller.Entry<Integer, Character>> {
    Generator<Integer> kGen = new CommonGenerator.IntGenerator();
    Generator<Character> vGen = new CommonGenerator.CharGenerator();

    @Override
    public Entry<Integer, Character> next() {
        Integer key = kGen.next();
        Character value = vGen.next();
        Entry<Integer, Character> entry = new Entry<>(key, value);
        return entry;
    }

}

public class Main {
    public static void main(String[] args) {
        Map<Integer, Character> map = MapFiller.getMap(new IntCharGenerator(), 5);
        System.out.println(map);
    }
}
// {0=a, 1=b, 2=c, 3=d, 4=e}