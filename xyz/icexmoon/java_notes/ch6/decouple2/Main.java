package ch6.decouple2;

import java.util.Random;

abstract class Sequence {
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

class NumberGenerator{
    private static Random random = new Random();
    public int getNumber(){
        return random.nextInt(100);
    }
}

public class Main {
    public static void main(String[] args) {
        Sequence s1 = new NumberSequence(new int[] { 1, 2, 3 });
        Sequence s2 = new CharSequence(new char[]{'a','b','c'});
        s1.print();
        s2.print();
    }
}
