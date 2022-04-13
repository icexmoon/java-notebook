package ch19.enum_set;

import java.util.EnumSet;

enum WeekDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class Main {
    public static void main(String[] args) {
        EnumSet<WeekDay> weekday = EnumSet.noneOf(WeekDay.class);
        weekday.add(WeekDay.MONDAY);
        System.out.println(weekday);
        weekday.addAll(EnumSet.of(WeekDay.TUESDAY, WeekDay.FRIDAY));
        System.out.println(weekday);
        weekday.addAll(EnumSet.allOf(WeekDay.class));
        System.out.println(weekday);
        weekday.removeAll(EnumSet.range(WeekDay.FRIDAY, WeekDay.SUNDAY));
        System.out.println(weekday);
        weekday.remove(WeekDay.MONDAY);
        System.out.println(weekday);
    }
}
// [MONDAY]
// [MONDAY, TUESDAY, FRIDAY]
// [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY]
// [MONDAY, TUESDAY, WEDNESDAY, THURSDAY]
// [TUESDAY, WEDNESDAY, THURSDAY]