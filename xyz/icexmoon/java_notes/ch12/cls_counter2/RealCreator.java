package ch12.cls_counter2;

import java.util.ArrayList;
import java.util.List;

public class RealCreator extends AnimalCreator {

    private static List<Class<? extends Animal>> animalTypes;
    private static String[] animalClsNames = new String[] {
            "ch12.cls_counter2.Cat",
            "ch12.cls_counter2.Dog",
            "ch12.cls_counter2.SportingDog",
            "ch12.cls_counter2.WorkingDog",
            "ch12.cls_counter2.HerdingDog",
            "ch12.cls_counter2.PersianCat",
            "ch12.cls_counter2.BirmanCat"
    };
    static {
        loadAnimalTypes();
    }

    private static void loadAnimalTypes() {
        animalTypes = new ArrayList<>();
        for (String string : animalClsNames) {
            try {
                animalTypes.add((Class<? extends Animal>) Class.forName(string));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected List<Class<? extends Animal>> getAnimalTypes() {
        return animalTypes;
    }

}
