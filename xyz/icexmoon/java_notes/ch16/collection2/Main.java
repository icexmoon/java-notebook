package ch16.collection2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ch15.test2.ArrayFiller;
import ch15.test2.CommonGenerator;
import ch15.test2.Generator;
import ch16.generator.ListFiller;

public class Main {
    public static void main(String[] args) {
        String[] arr = "abcdefg".split("");
        List<String> list1 = new ArrayList<>(Arrays.asList(arr));
        List<String> list2 = Arrays.asList(arr);
        List<String> list1Copy = new ArrayList<>(list1);
        List<String> list3 = Collections.unmodifiableList(list1Copy);
        Generator<String> gen = new CommonGenerator.StringGenerator();
        test("normal list", list1, gen);
        test("asList", list2, gen);
        test("unmodifiableList", list3, gen);
    }

    public static <E> void test(String msg, List<E> list, Generator<E> gen) {
        System.out.println("===========" + msg + "==============");
        Collection<E> collection = list;
        Collection<E> other = new ArrayList<>(list.subList(0, 2));
        try {
            collection.remove(gen.next());
        } catch (Exception e) {
            System.out.println("remove():" + e);
        }
        try {
            collection.removeAll(other);
        } catch (Exception e) {
            System.out.println("removeAll():" + e);
        }
        try {
            collection.retainAll(other);
        } catch (Exception e) {
            System.out.println("retainAll():" + e);
        }
        try {
            collection.clear();
        } catch (Exception e) {
            System.out.println("clear():" + e);
        }
        try {
            collection.add(gen.next());
        } catch (Exception e) {
            System.out.println("add():" + e);
        }
        try {
            collection.addAll(other);
        } catch (Exception e) {
            System.out.println("addAll():" + e);
        }
        try {
            list.set(0, gen.next());
        } catch (Exception e) {
            System.out.println("set():" + e);
        }
    }
}
// ===========normal list==============
// ===========asList==============
// removeAll():java.lang.UnsupportedOperationException: remove
// retainAll():java.lang.UnsupportedOperationException: remove
// clear():java.lang.UnsupportedOperationException
// add():java.lang.UnsupportedOperationException
// addAll():java.lang.UnsupportedOperationException
// ===========unmodifiableList==============
// remove():java.lang.UnsupportedOperationException
// removeAll():java.lang.UnsupportedOperationException
// retainAll():java.lang.UnsupportedOperationException
// clear():java.lang.UnsupportedOperationException
// add():java.lang.UnsupportedOperationException
// addAll():java.lang.UnsupportedOperationException
// set():java.lang.UnsupportedOperationException