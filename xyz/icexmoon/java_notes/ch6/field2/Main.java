package ch6.field2;

import java.util.Random;

interface WeekDay {
    int MONDAY = 1,
            TUESDAY = 2,
            WEDNESDAY = 3,
            THURSDAY = 4,
            FRIADAY = 5,
            SATURDAY = 6,
            SUNDAY = 7;
    Random RANDOM = new Random();
    int RANDOM_WEEK_DAY = RANDOM.nextInt(7) + 1;
}

public class Main {
    public static void main(String[] args) {
        System.out.println(WeekDay.MONDAY);
        System.out.println(WeekDay.RANDOM_WEEK_DAY);
    }
}
