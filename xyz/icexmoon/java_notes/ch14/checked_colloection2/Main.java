package ch14.checked_colloection2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pet {
};

class Cat extends Pet {
}

class Dog extends Pet {
}

public class Main {
    public static void main(String[] args) {
        List<Cat> cats = Collections.checkedList(new ArrayList<Cat>(), Cat.class);
        addDog(cats, new Dog());
        // Exception in thread "main" java.lang.ClassCastException: Attempt to insert
        // class ch14.checked_colloection2.Dog element into collection with element type
        // class ch14.checked_colloection2.Cat
        // at
        // java.base/java.util.Collections$CheckedCollection.typeCheck(Collections.java:3097)
        // at
        // java.base/java.util.Collections$CheckedCollection.add(Collections.java:3145)
        // at ch14.checked_colloection2.Main.addDog(Main.java:25)
        // at ch14.checked_colloection2.Main.main(Main.java:19)
        Cat c = cats.get(0);
    }

    @SuppressWarnings("unchecked")
    public static void addDog(List dogs, Dog dog) {
        dogs.add(dog);
    }
}
