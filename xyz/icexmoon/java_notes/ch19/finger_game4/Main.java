package ch19.finger_game4;

import java.util.Random;

import ch15.test2.Generator;
import util.Fmt;

enum Result {
    WIN, LOSE, DRAW
}

enum Item {
    PAPER(Result.DRAW, Result.WIN, Result.LOSE),
    ROCK(Result.LOSE, Result.DRAW, Result.WIN),
    SCISSORS(Result.WIN, Result.LOSE, Result.DRAW);

    private Result vsPaper;
    private Result vsRock;
    private Result vsScissors;

    private Item(Result vsPaper, Result vsRock, Result vsScissors) {
        this.vsPaper = vsPaper;
        this.vsRock = vsRock;
        this.vsScissors = vsScissors;
    }

    public Result compete(Item item) {
        switch (item) {
            case PAPER:
                return this.vsPaper;
            case ROCK:
                return this.vsRock;
            case SCISSORS:
                return this.vsScissors;
            default:
                return null;
        }
    }
}

class RandomItem implements Generator<Item> {
    private static Random rand = new Random();

    @Override
    public Item next() {
        Item[] items = Item.values();
        return items[rand.nextInt(items.length)];
    }

}

public class Main {
    public static void main(String[] args) {
        RandomItem ri = new RandomItem();
        for (int i = 0; i < 10; i++) {
            vs(ri.next(), ri.next());
        }
    }

    private static void vs(Item item1, Item item2) {
        Result r = item1.compete(item2);
        Fmt.printf("%s vs %s = %s\n", item1, item2, r);
    }
}
