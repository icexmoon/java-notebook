package ch19.constant_method;

enum WeekDay {
    MONDAY {
        @Override
        public String chinese() {
            return "星期一";
        }
    },
    TUESDAY {
        @Override
        public String chinese() {
            return "星期二";
        }
    },
    WEDNESDAY {
        @Override
        public String chinese() {
            return "星期三";
        }
    },
    THURSDAY {
        @Override
        public String chinese() {
            return "星期四";
        }
    },
    FRIDAY {
        @Override
        public String chinese() {
            return "星期五";
        }
    },
    SATURDAY {
        @Override
        public String chinese() {
            return "星期六";
        }
    },
    SUNDAY {
        @Override
        public String chinese() {
            return "星期天";
        }
    };

    public abstract String chinese();
}

public class Main {
    public static void main(String[] args) {
        for (WeekDay weekDay : WeekDay.values()) {
            System.out.println(weekDay.chinese());
        }
    }
}
// 星期一
// 星期二
// 星期三
// 星期四
// 星期五
// 星期六
// 星期天
