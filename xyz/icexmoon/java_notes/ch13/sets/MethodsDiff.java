package ch13.sets;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MethodsDiff {
    private static final Set<String> objectMethodNames = getObjectMethodNames();

    private static Set<String> getObjectMethodNames() {
        Set<String> methodNames = getMethodNames(Object.class);
        methodNames.add("clone");
        return methodNames;
    }

    private static Set<String> getMethodNames(Class<?> type) {
        Set<String> methodNames = new HashSet<>();
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            methodNames.add(method.getName());
        }
        return methodNames;
    }

    public static void printMethodsDiff(Class<?> type1, Class<?> type2) {
        Set<String> methodNames1 = getMethodNames(type1);
        Set<String> methodNames2 = getMethodNames(type2);
        Set<String> diffMethodNames = Sets.difference(methodNames1, methodNames2);
        diffMethodNames = Sets.difference(diffMethodNames, objectMethodNames);
        System.out.println(diffMethodNames);
    }

    public static void main(String[] args) {
        printMethodsDiff(ArrayList.class, List.class);
        printMethodsDiff(LinkedList.class, List.class);
    }
}
// [trimToSize, ensureCapacity]
// [descendingIterator, offerFirst, poll, getLast, pollLast, removeLast, offer,
// pop, addLast, getFirst, removeFirst, element, removeLastOccurrence,
// peekFirst, peekLast, push, peek, offerLast, pollFirst, removeFirstOccurrence,
// addFirst]
