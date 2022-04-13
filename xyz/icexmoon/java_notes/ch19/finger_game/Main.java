package ch19.finger_game;

import java.util.Random;

import ch15.test2.Generator;
import util.Fmt;

abstract class Item {
    public abstract Result compete(Rock rock);

    public abstract Result compete(Scissors scissors);

    public abstract Result compete(Paper paper);

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

class Rock extends Item {

    @Override
    public Result compete(Rock rock) {
        return Result.DRAW;
    }

    @Override
    public Result compete(Scissors scissors) {
        return Result.WIN;
    }

    @Override
    public Result compete(Paper paper) {
        return Result.LOSE;
    }

}

class Scissors extends Item {

    @Override
    public Result compete(Rock rock) {
        return Result.LOSE;
    }

    @Override
    public Result compete(Scissors scissors) {
        return Result.DRAW;
    }

    @Override
    public Result compete(Paper paper) {
        return Result.WIN;
    }
}

class Paper extends Item {

    @Override
    public Result compete(Rock rock) {
        return Result.WIN;
    }

    @Override
    public Result compete(Scissors scissors) {
        return Result.LOSE;
    }

    @Override
    public Result compete(Paper paper) {
        return Result.DRAW;
    }
}

enum Result {
    WIN, LOSE, DRAW
}

class RandomItem implements Generator<Item> {
    private static Item[] items = new Item[] { new Rock(), new Paper(), new Scissors() };
    private static Random rand = new Random();

    @Override
    public Item next() {
        return items[rand.nextInt(items.length)];
    }

}

public class Main {
    public static void main(String[] args) {
        RandomItem ri = new RandomItem();
        for (int i = 0; i < 3; i++) {
            Item item = ri.next();
            competeTest(item);
        }
    }

    private static void competeTest(Item item) {
        Paper paper = new Paper();
        Result r = item.compete(paper);
        Fmt.printf("%s vs %s = %s\n", item, paper, r);
        Rock rock = new Rock();
        r = item.compete(rock);
        Fmt.printf("%s vs %s = %s\n", item, rock, r);
        Scissors scissors = new Scissors();
        r = item.compete(scissors);
        Fmt.printf("%s vs %s = %s\n", item, scissors, r);
    }

}
