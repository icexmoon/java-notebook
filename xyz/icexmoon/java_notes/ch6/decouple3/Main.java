package ch6.decouple3;

import java.util.Random;

interface Printable {
    void print();
}

abstract class Sequence implements Printable {
    abstract public Object next();

    abstract public boolean hasNext();

    public void print() {
        while (this.hasNext()) {
            System.out.print(this.next() + " ");
        }
        System.out.println();
    }
}

class NumberSequence extends Sequence {
    private int[] numbers;
    private int cursor;

    public NumberSequence(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Integer next() {
        Integer item = numbers[cursor];
        cursor++;
        return item;
    }

    @Override
    public boolean hasNext() {
        if (cursor >= numbers.length) {
            return false;
        }
        return true;
    }

}

class CharSequence extends Sequence {
    private char[] chars;
    private int cursor;

    public CharSequence(char[] chars) {
        this.chars = chars;
    }

    @Override
    public Character next() {
        Character item = chars[cursor];
        cursor++;
        return item;
    }

    @Override
    public boolean hasNext() {
        if (cursor >= chars.length) {
            return false;
        }
        return true;
    }

}

class NumberGenerator implements Printable {
    private static Random random = new Random();
    private int printTimes = random.nextInt(10);

    public int getNumber() {
        return random.nextInt(100);
    }

    @Override
    public void print() {
        for (int i = 0; i < printTimes; i++) {
            System.out.print(getNumber() + " ");
        }
        System.out.println();
    }

    public void setPrintTimes(int times) {
        if (times > 0) {
            printTimes = times;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Printable p1 = new NumberSequence(new int[] { 1, 2, 3 });
        Printable p2 = new CharSequence(new char[] { 'a', 'b', 'c' });
        p1.print();
        p2.print();
        NumberGenerator ng = new NumberGenerator();
        ng.setPrintTimes(5);
        ng.print();
        // 1 2 3 
        // a b c
        // 58 90 17 3 65 
    }
}
