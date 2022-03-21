package ch16.linked_map;

import java.util.LinkedHashMap;

import ch15.test2.CommonGenerator;
import ch15.test2.Generator;

public class Main {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Character> lhm = new LinkedHashMap<>(30, 0.75f, true);
        Generator<Integer> genKey = new CommonGenerator.IntGenerator();
        Generator<Character> genVal = new CommonGenerator.CharGenerator();
        for (int i = 0; i < 10; i++) {
            lhm.put(genKey.next(), genVal.next());
        }
        System.out.println(lhm);
        lhm.get(3);
        lhm.get(4);
        lhm.get(5);
        System.out.println(lhm);
    }
}
// {0=a, 1=b, 2=c, 3=d, 4=e, 5=f, 6=g, 7=h, 8=i, 9=j}
// {0=a, 1=b, 2=c, 6=g, 7=h, 8=i, 9=j, 3=d, 4=e, 5=f}
