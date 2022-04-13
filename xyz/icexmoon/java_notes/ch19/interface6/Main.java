package ch19.interface6;

import java.util.Arrays;

import util.Enums;

interface Food {
    enum MainCourse implements Food {
        BRAISED_CHICKEN, STEWED_BEEF, BEEF_STEEK
    }

    enum Dessert implements Food {
        ICECREAM, COOKIE
    }

    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE
    }
}

enum Course {
    MAIN_COURSE(Food.MainCourse.class), DESSERT(Food.Dessert.class), COFFEE(Food.Coffee.class);

    private Food[] values;

    private Course(Class<? extends Food> cls) {
        values = cls.getEnumConstants();
    }

    public Food random() {
        return Enums.random(values);
    }
}

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            printMeal(getAMeal());
        }
    }

    private static Food[] getAMeal() {
        Food[] meal = new Food[Course.values().length];
        int i = 0;
        for (Course c : Course.values()) {
            meal[i++] = c.random();
        }
        return meal;
    }

    private static void printMeal(Food[] meal) {
        System.out.println(Arrays.toString(meal));
    }
}
// [BEEF_STEEK, ICECREAM, DECAF_COFFEE]
// [STEWED_BEEF, ICECREAM, BLACK_COFFEE]
// [STEWED_BEEF, ICECREAM, DECAF_COFFEE]
// [STEWED_BEEF, ICECREAM, BLACK_COFFEE]
// [BEEF_STEEK, ICECREAM, BLACK_COFFEE]