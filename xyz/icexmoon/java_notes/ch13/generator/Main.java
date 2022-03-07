package ch13.generator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class AnimalGenerator implements Generator<Animal>, Iterable<Animal> {
    private int size = 0;
    private List<Class<? extends Animal>> types = new ArrayList<>();
    {
        Collections.addAll(types, SportingDog.class, WorkingDog.class, HerdingDog.class, PersianCat.class,
                BirmanCat.class);
    }
    private static Random rand = new Random();

    public AnimalGenerator(int size) {
        this.size = size;
    }

    @Override
    public Animal next() {
        Class<? extends Animal> type = types.get(rand.nextInt(types.size()));
        Constructor<?> constructor;
        try {
            constructor = type.getDeclaredConstructor();
            return (Animal) constructor.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<Animal> iterator() {
        return new Iterator<Animal>() {
            private int nowSize = size;

            @Override
            public boolean hasNext() {
                return nowSize > 0;
            }

            @Override
            public Animal next() {
                if (nowSize <= 0) {
                    return null;
                }
                nowSize--;
                return AnimalGenerator.this.next();
            }

        };
    }

}

public class Main {
    public static void main(String[] args) {
        AnimalGenerator ag = new AnimalGenerator(5);
        for (int i = 0; i < 7; i++) {
            System.out.print(ag.next().toString() + " ");
        }
        System.out.println();
        for (Animal animal : ag) {
            System.out.print(animal.toString() + " ");
        }
    }
}
// 0#WorkingDog 1#HerdingDog 2#PersianCat 3#BirmanCat 4#SportingDog 5#BirmanCat 6#BirmanCat 
// 7#SportingDog 8#WorkingDog 9#PersianCat 10#HerdingDog 11#SportingDog