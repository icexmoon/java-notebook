package ch12.cls_counter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RealCreator rc = new RealCreator();
        List<Animal> animals = rc.randomAnimals(10);
        System.out.println(animals);
        AnimalCounter ac = new AnimalCounter(animals);
        ac.count();
        System.out.println(ac);
    }
}
// [ch12.cls_counter.WorkingDog, ch12.cls_counter.Dog, ch12.cls_counter.Dog,
// ch12.cls_counter.HerdingDog, ch12.cls_counter.BirmanCat,
// ch12.cls_counter.BirmanCat, ch12.cls_counter.BirmanCat,
// ch12.cls_counter.SportingDog, ch12.cls_counter.Dog, ch12.cls_counter.Cat]
// [Animal=10,WorkingDog=1,Cat=4,BirmanCat=3,SportingDog=1,Dog=6,HerdingDog=1]
