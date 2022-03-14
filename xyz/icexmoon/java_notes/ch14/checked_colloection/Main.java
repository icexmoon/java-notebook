package ch14.checked_colloection;

import java.util.ArrayList;
import java.util.List;

class Pet {
};

class Cat extends Pet {
}

class Dog extends Pet {
}

public class Main {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        addDog(cats, new Dog());
        Cat c = cats.get(0);
        // Exception in thread "main" java.lang.ClassCastException: class
        // ch14.checked_colloection.Dog cannot be cast to class
        // ch14.checked_colloection.Cat (ch14.checked_colloection.Dog and
        // ch14.checked_colloection.Cat are in unnamed module of loader 'app')
        // at ch14.checked_colloection.Main.main(Main.java:19)
    }

    @SuppressWarnings("unchecked")
    public static void addDog(List dogs, Dog dog) {
        dogs.add(dog);
    }
}
