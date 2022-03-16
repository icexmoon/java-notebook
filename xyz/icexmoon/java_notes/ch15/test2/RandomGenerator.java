package ch15.test2;

import java.util.Random;

public class RandomGenerator {
    private static Random rand = new Random();

    public static class IntGenerator implements Generator<Integer> {
        private int max = 100;

        public IntGenerator() {
        }

        public IntGenerator(int max) {
            this.max = max;
        }

        @Override
        public Integer next() {
            return rand.nextInt(max);
        }

    }

    public static class CharGenerator implements Generator<Character> {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        @Override
        public Character next() {
            int index = rand.nextInt(chars.length);
            return chars[index];
        }

    }

    public static class StringGenerator implements Generator<String> {
        private int wordsLength = 5;
        private static CharGenerator charGenerator = new CharGenerator();

        public StringGenerator() {
        }

        public StringGenerator(int wordsLength) {
            this.wordsLength = wordsLength;
        }

        @Override
        public String next() {
            char[] words = new char[wordsLength];
            for (int i = 0; i < words.length; i++) {
                words[i] = charGenerator.next();
            }
            return new String(words);
        }

    }

    public static void main(String[] args) {
        CommonGenerator.test(RandomGenerator.class);
    }
}
// CharGenerator: a b k d h y f a y a
// IntGenerator: 13 0 63 48 40 51 82 41 5 29
// StringGenerator: jsnfh ctwsc mumxw bhode xigwo lyguy zkiaq nrajs nlpnd lqbqw
