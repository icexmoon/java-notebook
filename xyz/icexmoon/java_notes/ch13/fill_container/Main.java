package ch13.fill_container;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import ch13.generator.Generator;
import ch13.generator3.FibonacciGenerator;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Generator<Integer> fg = new FibonacciGenerator();
        fillContainerByGenerator(numbers, fg, 10);
        System.out.println(numbers);
    }

    /**
     * 用生成器给容器填充指定数目的元素
     * 
     * @param <T>       元素类型
     * @param container 容器
     * @param generator 生成器
     * @param num       指定数目
     */
    private static <T> void fillContainerByGenerator(Collection<T> container, Generator<T> generator, int num) {
        if (num <= 0) {
            return;
        }
        for (int i = 0; i < num; i++) {
            container.add(generator.next());
        }
    }
}
// [1, 1, 2, 3, 5, 8, 13, 21, 34, 55]
