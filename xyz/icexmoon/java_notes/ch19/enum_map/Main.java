package ch19.enum_map;

import java.util.EnumMap;
import java.util.Map;

interface DayLife {
    void doSomething();
}

enum WeekDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class Main {
    public static void main(String[] args) {
        EnumMap<WeekDay, DayLife> weekLife = new EnumMap<>(WeekDay.class);
        initWeekLife(weekLife);
        showWeekLife(weekLife);
        weekLife.put(WeekDay.MONDAY, new DayLife() {
            @Override
            public void doSomething() {
                System.out.println("working...");
            }
        });
        weekLife.put(WeekDay.TUESDAY, new DayLife() {
            @Override
            public void doSomething() {
                System.out.println("shopping...");
            }
        });
        weekLife.put(WeekDay.SUNDAY, new DayLife() {
            @Override
            public void doSomething() {
                System.out.println("go fishing...");
            }
        });
        showWeekLife(weekLife);
    }

    private static void showWeekLife(EnumMap<WeekDay, DayLife> weekLife) {
        System.out.println("============ week life ==========");
        for (Map.Entry<WeekDay, DayLife> entry : weekLife.entrySet()) {
            WeekDay weekDay = entry.getKey();
            DayLife dayLife = entry.getValue();
            if (null != dayLife) {
                System.out.print(weekDay + ": ");
                dayLife.doSomething();
            }
        }
    }

    private static void initWeekLife(EnumMap<WeekDay, DayLife> weekLife) {
        for (WeekDay weekDay : WeekDay.values()) {
            weekLife.put(weekDay, new DayLife() {
                @Override
                public void doSomething() {
                    System.out.println("need do nothing.");
                }
            });
        }
    }
}
// ============ week life ==========
// MONDAY: need do nothing.
// TUESDAY: need do nothing.
// WEDNESDAY: need do nothing.
// THURSDAY: need do nothing.
// FRIDAY: need do nothing.
// SATURDAY: need do nothing.
// SUNDAY: need do nothing.
// ============ week life ==========
// MONDAY: working...
// TUESDAY: shopping...
// WEDNESDAY: need do nothing.
// THURSDAY: need do nothing.
// FRIDAY: need do nothing.
// SATURDAY: need do nothing.
// SUNDAY: go fishing...