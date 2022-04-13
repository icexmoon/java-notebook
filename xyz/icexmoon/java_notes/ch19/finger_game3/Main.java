package ch19.finger_game3;

import java.util.Random;

import ch15.test2.Generator;
import util.Fmt;

abstract class Item {
    public abstract Result compete(Rock rock);

    public abstract Result compete(Scissors scissors);

    public abstract Result compete(Paper paper);

    public abstract Result compete(Item item);

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

    @Override
    public Result compete(Item item) {
        return item.compete(this).reverse();
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

    @Override
    public Result compete(Item item) {
        return item.compete(this).reverse();
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

    @Override
    public Result compete(Item item) {
        return item.compete(this).reverse();
    }
}

enum Result {
    WIN, LOSE, DRAW;

    public Result reverse() {
        switch (this) {
            case WIN:
                return LOSE;
            case LOSE:
                return WIN;
            case DRAW:
                return DRAW;
            default:
                return null;
        }
    }
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
        for (int i = 0; i < 10; i++) {
            Item item1 = ri.next();
            Item item2 = ri.next();
            vs(item1, item2);
        }
    }

    private static void vs(Item item1, Item item2) {
        Result r = item1.compete(item2);
        Fmt.printf("%s vs %s = %s\n", item1, item2, r);
    }

}
// Paper vs Scissors = LOSE
// Rock vs Scissors = WIN
// Rock vs Paper = LOSE
// Scissors vs Paper = WIN
// Scissors vs Paper = WIN
// Scissors vs Scissors = DRAW
// Rock vs Scissors = WIN
// Scissors vs Paper = WIN
// Paper vs Rock = WIN