package ch1.label;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        outer: for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int randInt = rand.nextInt(100);
                System.out.print(randInt+"\t");
                if (randInt == 99){
                    break outer;
                }
            }
            System.out.println();
        }
    }
}
