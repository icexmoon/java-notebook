package ch8.un_list;

import java.util.List;

class MyInteger {
    private int number;

    public MyInteger(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof MyInteger) {
            MyInteger other = (MyInteger) obj;
            return other.number == this.number;
        } else {
            return super.equals(obj);
        }
    }

    @Override
    public String toString() {
        return Integer.toString(this.number);
    }

    public void setValue(int value) {
        this.number = value;
    }
}

public class Main {
    private static MyInteger[] getNumbers() {
        int length = 10;
        MyInteger[] numbers = new MyInteger[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = new MyInteger(i);
        }
        return numbers;
    }

    public static void main(String[] args) {
        MyInteger[] numbers = getNumbers();
        List<MyInteger> list = List.of(numbers);
        System.out.println(list);
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        list.get(0).setValue(99);
        System.out.println(list);
        // [99, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        list.remove(1);
        // Exception in thread "main" java.lang.UnsupportedOperationException
    }
}
