package ch12.bad3;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import util.Fmt;

interface NameAble {
    String getName();
}

class School {
    public static NameAble getNameAble() {
        return new Person("New Employee");
    }

    private static class Person implements NameAble {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        public void walk() {
            Fmt.printf("%s is walking.\n", name);
        }

    }
}

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        NameAble n = School.getNameAble();
        System.out.println(n.getName());
        Method method = n.getClass().getMethod("walk");
        method.invoke(n);
        Field name = n.getClass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(n, "Li Lei");
        method.invoke(n);
    }
}
// New Employee
// New Employee is walking.
// Li Lei is walking.