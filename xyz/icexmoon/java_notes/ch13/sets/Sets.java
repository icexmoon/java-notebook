package ch13.sets;

import java.util.HashSet;
import java.util.Set;

/**
 * 集合运算
 */
public class Sets {
    /**
     * 并运算
     * 
     * @param <T>
     * @param set1 集合1
     * @param set2 集合2
     * @return 集合1和集合2的并集
     */
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    /**
     * 交运算
     * 
     * @param <T>
     * @param set1 集合1
     * @param set2 集合2
     * @return 集合1与集合2的交集
     */
    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    /**
     * 差集（补集）
     * 
     * @param <T>
     * @param set1 集合1
     * @param set2 集合2
     * @return 集合1对集合2的差集
     */
    public static <T> Set<T> difference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.removeAll(set2);
        return result;
    }

    /**
     * 互补
     * 
     * @param <T>
     * @param set1 集合1
     * @param set2 集合2
     * @return 集合1和集合2的互补
     */
    public static <T> Set<T> complement(Set<T> set1, Set<T> set2) {
        return difference(union(set1, set2), intersection(set1, set2));
    }
}
