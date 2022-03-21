package ch16.error;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import ch15.test2.CommonGenerator;
import ch16.generator.ListFiller;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = ListFiller.getList(new CommonGenerator.IntGenerator(), 10);
        Iterator<Integer> iterator = list.iterator();
        list.remove(0);
        do {
            try {
                Integer num = iterator.next();
            } catch (NoSuchElementException e) {
                break;
            }
        } while (true);
    }
}
// Exception in thread "main" java.util.ConcurrentModificationException
// at
// java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
// at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
// at ch16.error.Main.main(Main.java:17)
