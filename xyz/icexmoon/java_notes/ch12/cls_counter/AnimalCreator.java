package ch12.cls_counter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract public class AnimalCreator {
    private static Random rand = new Random();

    abstract protected List<Class<? extends Animal>> getAnimalTypes();

    private Animal randomAnimal() {
        int total = getAnimalTypes().size();
        if (total == 0) {
            return null;
        }
        try {
            return (Animal) getAnimalTypes().get(rand.nextInt(total)).getDeclaredConstructors()[0].newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Animal> randomAnimals(int num) {
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            animals.add(randomAnimal());
        }
        return animals;
    }
}
