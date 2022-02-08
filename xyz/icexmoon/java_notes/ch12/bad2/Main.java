package ch12.bad2;

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
            Fmt.printf("%s is walking.", name);
        }

    }
}

public class Main {
    public static void main(String[] args) {
        NameAble n = School.getNameAble();
        System.out.println(n.getName());
        // Person p = (Person) n;
        // p.walk();
        // Person cannot be resolved to a type
    }
}
// New Employee