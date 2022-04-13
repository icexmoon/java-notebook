package ch19.interface5;

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

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            printMeal(getAMeal());
        }
    }

    private static Food[] getAMeal() {
        Food[] meal = new Food[3];
        meal[0] = Enums.random(Food.MainCourse.class);
        meal[1] = Enums.random(Food.Dessert.class);
        meal[2] = Enums.random(Food.Coffee.class);
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