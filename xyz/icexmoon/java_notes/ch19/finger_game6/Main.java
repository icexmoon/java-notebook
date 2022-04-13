package ch19.finger_game6;

import java.util.Random;

import ch15.test2.Generator;
import util.Fmt;

enum Result {
    WIN, LOSE, DRAW
}

enum Item {
    PAPER {
        @Override
        public Result compete(Item item) {
            return compete(ROCK, item);
        }
    },
    ROCK {
        @Override
        public Result compete(Item item) {
            return compete(SCISSORS, item);
        }
    },
    SCISSORS {
        @Override
        public Result compete(Item item) {
            return compete(PAPER, item);
        }
    };

    public abstract Result compete(Item item);

    protected Result compete(Item loser, Item item) {
        return item == this ? Result.DRAW : (item == loser ? Result.WIN : Result.LOSE);
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
