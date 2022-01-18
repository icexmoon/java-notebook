package ch6.field;

interface WeekDay {
    int MONDAY = 1,
            TUESDAY = 2,
            WEDNESDAY = 3,
            THURSDAY = 4,
            FRIADAY = 5,
            SATURDAY = 6,
            SUNDAY = 7;
}

public class Main {
    public static void main(String[] args) {
        System.out.println(WeekDay.MONDAY);
    }
}
