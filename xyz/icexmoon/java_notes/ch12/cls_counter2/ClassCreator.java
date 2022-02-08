package ch12.cls_counter2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassCreator extends AnimalCreator {

    public static List<Class<? extends Animal>> animalTypes;
    private static List<Class<? extends Animal>> subTypes;
    static {
        loadAnimalTypes();
    }

    private static void loadAnimalTypes() {
        animalTypes = new ArrayList<>();
        Collections.addAll(animalTypes, Animal.class, Dog.class, Cat.class, SportingDog.class, WorkingDog.class,
                HerdingDog.class, PersianCat.class, BirmanCat.class);
        subTypes = animalTypes.subList(3, animalTypes.size());
    }

    @Override
    protected List<Class<? extends Animal>> getAnimalTypes() {
        return subTypes;
    }

}
