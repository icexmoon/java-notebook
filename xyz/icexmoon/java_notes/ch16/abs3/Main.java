package ch16.abs3;

import java.util.AbstractList;
import java.util.List;

class SampleList2 extends AbstractList<Integer> {
    private final int size;

    public SampleList2(int size) {
        if (size < 0) {
            size = 0;
        }
        this.size = size;
    }

    public SampleList2() {
        this(10);
    }

    @Override
    public Integer get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return Integer.valueOf(index);
    }

    @Override
    public int size() {
        return size;
    }

}

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new SampleList2();
        System.out.println(list);
    }
}
// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
