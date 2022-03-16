package ch15.test2;

public class CommonGenerator {
    public static class IntGenerator implements Generator<Integer> {
        private int counter = 0;

        @Override
        public Integer next() {
            return counter++;
        }

    }

    public static class CharGenerator implements Generator<Character> {
        private static char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        private int index = -1;

        @Override
        public Character next() {
            index = (index + 1) % chars.length;
            return chars[index];
        }

    }

    public static class StringGenerator implements Generator<String> {
        private CharGenerator charGenerator = new CharGenerator();
        private int wordsLength = 5;

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
        test(CommonGenerator.class);
    }

    @SuppressWarnings("unchecked")
    public static void test(Class<?> cls) {
        Class<?>[] clses = cls.getClasses();
        for (Class<?> genCls : clses) {
            Class<Generator<?>> genCls2 = (Class<Generator<?>>) genCls;
            testGen(genCls2);
        }
    }

    private static <T> void testGen(Class<? extends Generator<T>> genCls) {
        Generator<T> gen = null;
        try {
            gen = genCls.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.print(genCls.getSimpleName() + ": ");
        for (int i = 0; i < 10; i++) {
            System.out.print(gen.next() + " ");
        }
        System.out.println();
    }
}
// CharGenerator: a b c d e f g h i j
// IntGenerator: 0 1 2 3 4 5 6 7 8 9
// StringGenerator: abcde fghij klmno pqrst uvwxy zabcd efghi jklmn opqrs tuvwx