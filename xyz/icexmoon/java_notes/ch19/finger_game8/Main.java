package ch19.finger_game8;

import java.util.EnumMap;
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

    private static EnumMap<Item, EnumMap<Item, Result>> table = new EnumMap<>(Item.class);

    static {
        EnumMap<Item, Result> paperRow = new EnumMap<>(Item.class);
        EnumMap<Item, Result> rockRow = new EnumMap<>(Item.class);
        EnumMap<Item, Result> scissorsRow = new EnumMap<>(Item.class);
        table.put(PAPER, paperRow);
        table.put(ROCK, rockRow);
        table.put(SCISSORS, scissorsRow);
        paperRow.put(PAPER, Result.DRAW);
        paperRow.put(ROCK, Result.WIN);
        paperRow.put(SCISSORS, Result.LOSE);
        rockRow.put(PAPER, Result.LOSE);
        rockRow.put(SCISSORS, Result.WIN);
        rockRow.put(ROCK, Result.DRAW);
        scissorsRow.put(SCISSORS, Result.DRAW);
        scissorsRow.put(ROCK, Result.LOSE);
        scissorsRow.put(PAPER, Result.WIN);
    }

    public Result compete(Item item) {
        return table.get(this).get(item);
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
