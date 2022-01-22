package ch9.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch8.collection.Collection;
import util.Fmt;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            if (this.name == p.name && this.age == p.age) {
                return true;
            }
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Person(name:%s,age:%d)", name, age);
    }
}

class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Pet(%s)", type);
    }
}

public class Main {
    public static void main(String[] args) {
        Map<Person, List<Pet>> persons = new HashMap<>();
        List<Pet> pets1 = new ArrayList<Pet>();
        Collections.addAll(pets1, new Pet("bird"), new Pet("dog"));
        persons.put(new Person("Li Lei", 19), pets1);
        List<Pet> pets2 = new ArrayList<Pet>();
        Collections.addAll(pets2, new Pet("cat"));
        persons.put(new Person("Han Meimei", 15), pets2);
        for (Person p : persons.keySet()) {
            System.out.println(p);
            for (Pet pet : persons.get(p)) {
                System.out.print(pet + " ");
            }
            System.out.println();
        }
        // Person(name:Han Meimei,age:15)
        // Pet(cat) 
        // Person(name:Li Lei,age:19)
        // Pet(bird) Pet(dog)
    }
}
