package ch16.abs4;

import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Students {
    private static String[][] info = { { "Han Meimei", "19" }, { "Li Lei", "20" }, { "Jack Chen", "15" },
            { "Brus Lee", "11" } };

    private static class NameList extends AbstractList<String> {

        @Override
        public String get(int index) {
            return info[index][0];
        }

        @Override
        public int size() {
            return info.length;
        }

    }

    private static class AgeList extends AbstractList<Integer> {

        @Override
        public Integer get(int index) {
            return Integer.valueOf(info[index][1]);
        }

        @Override
        public int size() {
            return info.length;
        }

    }

    private static class StudentMap extends AbstractMap<String, Integer> {
        private static class StudentEntry implements Entry<String, Integer> {
            private int index = -1;

            public StudentEntry() {
            }

            @Override
            public String getKey() {
                return info[index][0];
            }

            @Override
            public Integer getValue() {
                return Integer.valueOf(info[index][1]);
            }

            @Override
            public Integer setValue(Integer value) {
                throw new UnsupportedOperationException();
            }

        }

        private static class StudentEntrySet extends LinkedHashSet<Entry<String, Integer>> {
            private StudentEntry se = new StudentEntry();

            @Override
            public Iterator<Entry<String, Integer>> iterator() {
                return new Iterator<Map.Entry<String, Integer>>() {

                    @Override
                    public boolean hasNext() {
                        if (se.index >= info.length - 1) {
                            return false;
                        }
                        return true;
                    }

                    @Override
                    public Entry<String, Integer> next() {
                        se.index++;
                        return se;
                    }

                };
            }
        }

        @Override
        public Set<Entry<String, Integer>> entrySet() {
            return new StudentEntrySet();
        }

    }

    public static Map<String, Integer> studentMap() {
        return new StudentMap();
    }

    public static List<String> names() {
        return new NameList();
    }

    public static List<Integer> ages() {
        return new AgeList();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Students.studentMap());
        System.out.println(Students.names());
        System.out.println(Students.ages());
    }
}
// {Han Meimei=19, Li Lei=20, Jack Chen=15, Brus Lee=11}
// [Han Meimei, Li Lei, Jack Chen, Brus Lee]
// [19, 20, 15, 11]
