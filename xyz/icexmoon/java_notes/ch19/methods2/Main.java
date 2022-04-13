package ch19.methods2;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import util.Fmt;

public class Main {
    public static void main(String[] args) {
        Set<String> subMethods = analysis(Color.class);
        Set<String> superMethods = analysis(Enum.class);
        subMethods.removeAll(superMethods);
        System.out.println(subMethods);
    }

    private static <T extends Enum> Set<String> analysis(Class<T> cls) {
        Fmt.printf("========analysis %s=========\n", cls.getName());
        System.out.println("super class:" + cls.getSuperclass().getName());
        System.out.println("interfaces:" + Arrays.toString(cls.getInterfaces()));
        Set<String> methods = new HashSet<>();
        for (Method method : cls.getMethods()) {
            methods.add(method.getName());
        }
        System.out.println("methods:" + methods);
        return methods;
    }
}
// ========analysis ch19.methods2.Color=========
// super class:java.lang.Enum
// interfaces:[]
// methods:[getClass, wait, valueOf, values, notifyAll, compareTo, describeConstable, notify, getDeclaringClass, hashCode, equals, name, toString, ordinal]
// ========analysis java.lang.Enum=========
// super class:java.lang.Object
// interfaces:[interface java.lang.constant.Constable, interface java.lang.Comparable, interface java.io.Serializable]
// methods:[getClass, wait, valueOf, notifyAll, compareTo, describeConstable, notify, getDeclaringClass, hashCode, equals, name, toString, ordinal]
// [values]