package ch19.finger_game9;

import java.util.Random;

import ch15.test2.Generator;
import util.Fmt;

enum Result {
    WIN, LOSE, DRAW
}

enum Item {
    PAPER,
    ROCK,
    SCISSORS;

    private static final int SIZE = Item.values().length;

    private static Result[][] table = new Result[SIZE][];

    static {
        table[PAPER.ordinal()] = new Result[SIZE];
        table[ROCK.ordinal()] = new Result[SIZE];
        table[SCISSORS.ordinal()] = new Result[SIZE];
        Result[] paperRow = table[PAPER.ordinal()];
        paperRow[PAPER.ordinal()] = Result.DRAW;
        paperRow[SCISSORS.ordinal()] = Result.LOSE;
        paperRow[ROCK.ordinal()] = Result.WIN;
        Result[] rockRow = table[ROCK.ordinal()];
        rockRow[ROCK.ordinal()] = Result.DRAW;
        rockRow[PAPER.ordinal()] = Result.LOSE;
        rockRow[SCISSORS.ordinal()] = Result.WIN;
        Result[] scissorsRow = table[SCISSORS.ordinal()];
        scissorsRow[SCISSORS.ordinal()] = Result.DRAW;
        scissorsRow[PAPER.ordinal()] = Result.WIN;
        scissorsRow[ROCK.ordinal()] = Result.LOSE;
    }

    public Result compete(Item item) {
        return table[this.ordinal()][item.ordinal()];
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
