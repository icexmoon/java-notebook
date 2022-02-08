package ch12.cls_counter4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FactoryCreator fc = new FactoryCreator();
        fc.registeAllFactory();
        List<Animal> animals = fc.randomAnimals(10);
        System.out.println(animals);
        TypeCounter tc = new TypeCounter(Animal.class);
        tc.count(animals);
        System.out.println(tc);
    }
}
// [ch12.cls_counter4.SportingDog, ch12.cls_counter4.WorkingDog,
// ch12.cls_counter4.WorkingDog, ch12.cls_counter4.HerdingDog,
// ch12.cls_counter4.PersianCat, ch12.cls_counter4.SportingDog,
// ch12.cls_counter4.HerdingDog, ch12.cls_counter4.SportingDog,
// ch12.cls_counter4.SportingDog, ch12.cls_counter4.HerdingDog]
// [Dog=9, Cat=1, PersianCat=1, Animal=10, HerdingDog=3, SportingDog=4,
// WorkingDog=2]