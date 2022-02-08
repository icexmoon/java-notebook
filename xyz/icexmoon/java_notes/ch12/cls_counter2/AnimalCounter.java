package ch12.cls_counter2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalCounter {
    private Map<String, Integer> counter = new HashMap<>();
    private List<Animal> animals;

    public AnimalCounter(List<Animal> animals) {
        this.animals = animals;
    }

    private void countCls(String clsName) {
        Object value = counter.get(clsName);
        if (value == null) {
            counter.put(clsName, 1);
        } else {
            counter.put(clsName, (int) value + 1);
        }
    }

    public void count() {
        for (Animal animal : animals) {
            if (animal instanceof Animal) {
                countCls("Animal");
            }
            if (animal instanceof Cat) {
                countCls("Cat");
            }
            if (animal instanceof Dog) {
                countCls("Dog");
            }
            if (animal instanceof SportingDog) {
                countCls("SportingDog");
            }
            if (animal instanceof WorkingDog) {
                countCls("WorkingDog");
            }
            if (animal instanceof HerdingDog) {
                countCls("HerdingDog");
            }
            if (animal instanceof PersianCat) {
                countCls("PersianCat");
            }
            if (animal instanceof BirmanCat) {
                countCls("BirmanCat");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

}
