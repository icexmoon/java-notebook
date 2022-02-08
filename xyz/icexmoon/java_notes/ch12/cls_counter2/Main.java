package ch12.cls_counter2;

import java.util.List;

class Animal{
    @Override
    public String toString() {
        return this.getClass().getCanonicalName();
    }
}
class Cat extends Animal{}
class Dog extends Animal{}
class SportingDog extends Dog{}
class WorkingDog extends Dog{}
class HerdingDog extends Dog{}
class PersianCat extends Cat{}
class BirmanCat extends Cat{}

public class Main {
    public static void main(String[] args) {
        AnimalCreator rc = new ClassCreator();
        List<Animal> animals = rc.randomAnimals(10);
        System.out.println(animals);
        AnimalCounter2 ac = new AnimalCounter2(animals, ClassCreator.animalTypes);
        ac.count();
        System.out.println(ac);
    }
}
