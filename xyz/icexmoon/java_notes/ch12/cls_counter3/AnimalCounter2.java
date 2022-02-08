package ch12.cls_counter3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalCounter2 {
    private Map<String, Integer> counter = new HashMap<>();
    private List<Animal> animals;
    private List<Class<? extends Animal>> animalTypes;

    public AnimalCounter2(List<Animal> animals, List<Class<? extends Animal>> animalTypes) {
        this.animals = animals;
        this.animalTypes = animalTypes;
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
            for (Class<? extends Animal> animalType : animalTypes) {
                if (animalType.isInstance(animal)){
                    countCls(animalType.getSimpleName());
                }
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
