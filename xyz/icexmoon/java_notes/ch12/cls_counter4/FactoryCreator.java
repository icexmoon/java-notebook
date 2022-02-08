package ch12.cls_counter4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FactoryCreator {
    private static Random rand = new Random();
    private List<AnimalFactory> factorys = new ArrayList<>();

    public List<Animal> randomAnimals(int num) {
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            animals.add(randomAnimal());
        }
        return animals;
    }

    public void registeFactory(AnimalFactory factory) {
        factorys.add(factory);
    }

    public void registeAllFactory() {
        registeFactory(SportingDog.factory);
        registeFactory(WorkingDog.factory);
        registeFactory(HerdingDog.factory);
        registeFactory(PersianCat.factory);
        registeFactory(BirmanCat.factory);
    }

    private Animal randomAnimal() {
        if (factorys.size() <= 0) {
            return null;
        }
        int index = rand.nextInt(factorys.size());
        return factorys.get(index).create();
    }
}
