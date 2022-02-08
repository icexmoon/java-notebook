package ch12.cls_counter3;

import java.util.List;

class Animal {
    @Override
    public String toString() {
        return this.getClass().getCanonicalName();
    }
}

class Cat extends Animal {
}

class Dog extends Animal {
}

class SportingDog extends Dog {
}

class WorkingDog extends Dog {
}

class HerdingDog extends Dog {
}

class PersianCat extends Cat {
}

class BirmanCat extends Cat {
}

public class Main {
    public static void main(String[] args) {
        AnimalCreator rc = new ClassCreator();
        List<Animal> animals = rc.randomAnimals(10);
        System.out.println(animals);
        TypeCounter tc = new TypeCounter(Animal.class);
        tc.count(animals);
        System.out.println(tc);
    }
}
// [ch12.cls_counter3.SportingDog, ch12.cls_counter3.SportingDog,
// ch12.cls_counter3.HerdingDog, ch12.cls_counter3.HerdingDog,
// ch12.cls_counter3.BirmanCat, ch12.cls_counter3.HerdingDog,
// ch12.cls_counter3.PersianCat, ch12.cls_counter3.SportingDog,
// ch12.cls_counter3.WorkingDog, ch12.cls_counter3.WorkingDog]
// [PersianCat=1, WorkingDog=2, Cat=2, SportingDog=3, Animal=10, HerdingDog=3,
// BirmanCat=1, Dog=8]