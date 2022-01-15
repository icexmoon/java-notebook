package ch1.switch1;

import java.util.Random;

public class Main {
    public static boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
        }
        return false;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            char c = (char) ('a' + rand.nextInt(26));
            if (isVowel(c)) {
                System.out.println(c + " is Vowel.");
            } else {
                System.out.println(c + " is not Vowel.");
            }
        }
    }
}
// d is not Vowel.
// w is not Vowel.
// k is not Vowel.
// u is Vowel.
// e is Vowel.
// i is Vowel.
// d is not Vowel.
// e is Vowel.
// x is not Vowel.
// s is not Vowel.