package ch6.decouple4;

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

class NumberGenerator {
    private static Random random = new Random();

    public int getNumber() {
        return random.nextInt(100);
    }
}

class NGPrintAdapter implements Printable {
    private NumberGenerator ng;
    private int printTimes;

    public NGPrintAdapter(NumberGenerator ng, int printTimes) {
        this.ng = ng;
        if (printTimes < 0) {
            throw new Error();
        }
        this.printTimes = printTimes;
    }

    @Override
    public void print() {
        for (int i = 0; i < printTimes; i++) {
            System.out.print(ng.getNumber() + " ");
        }
        System.out.println();
    }

}

public class Main {
    public static void main(String[] args) {
        Printable p1 = new NumberSequence(new int[] { 1, 2, 3 });
        Printable p2 = new CharSequence(new char[] { 'a', 'b', 'c' });
        p1.print();
        p2.print();
        NumberGenerator ng = new NumberGenerator();
        Printable p3 = new NGPrintAdapter(ng, 6);
        p3.print();
        // 1 2 3 
        // a b c
        // 40 26 82 31 78 6
    }
}
