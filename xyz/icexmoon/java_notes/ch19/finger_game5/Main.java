package ch19.finger_game5;

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
            switch (item) {
                case PAPER:
                    return Result.DRAW;
                case ROCK:
                    return Result.WIN;
                case SCISSORS:
                    return Result.LOSE;
                default:
                    return null;
            }
        }
    },
    ROCK {
        @Override
        public Result compete(Item item) {
            switch (item) {
                case PAPER:
                    return Result.LOSE;
                case ROCK:
                    return Result.DRAW;
                case SCISSORS:
                    return Result.WIN;
                default:
                    return null;
            }
        }
    },
    SCISSORS {
        @Override
        public Result compete(Item item) {
            switch (item) {
                case PAPER:
                    return Result.WIN;
                case ROCK:
                    return Result.LOSE;
                case SCISSORS:
                    return Result.DRAW;
                default:
                    return null;
            }
        }
    };

    public abstract Result compete(Item item);
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
