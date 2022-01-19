package ch7.nonname4;

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

public class Main {
    public static void main(String[] args) {
        Printable p1 = new NumberSequence(new int[] { 1, 2, 3 });
        Printable p2 = new CharSequence(new char[] { 'a', 'b', 'c' });
        p1.print();
        p2.print();
        NumberGenerator ng = new NumberGenerator();
        Printable p3 = ng.getPrinter(6);
        p3.print();
        // 1 2 3
        // a b c
        // 40 26 82 31 78 6
    }
}
