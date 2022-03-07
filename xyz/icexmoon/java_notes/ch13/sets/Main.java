package ch13.sets;

import java.util.EnumSet;
import java.util.Set;

enum Color {
    BLUE, LIGHT_BLUE, DEEP_BLUE, RED, LIGHT_RED, DEEP_RED, YELLOW, LIGHT_YELLOW, DEEP_YELLOW, BLACK, PINK, LIGHT_PINK,
    DEEP_PINK
}

public class Main {
    public static void main(String[] args) {
        Set<Color> colors1 = EnumSet.range(Color.BLUE, Color.DEEP_RED);
        Set<Color> colors2 = EnumSet.range(Color.RED, Color.DEEP_YELLOW);
        System.out.println("colors1: " + colors1);
        System.out.println("colors2: " + colors2);
        System.out.println("colors1 union colors2: " + Sets.union(colors1, colors2));
        System.out.println("colors1 intersection colors2: " + Sets.intersection(colors1, colors2));
        System.out.println("colors1 difference colors2: " + Sets.difference(colors1, colors2));
        System.out.println("colors1 complement colors2: " + Sets.complement(colors1, colors2));
    }
}
// colors1: [BLUE, LIGHT_BLUE, DEEP_BLUE, RED, LIGHT_RED, DEEP_RED]
// colors2: [RED, LIGHT_RED, DEEP_RED, YELLOW, LIGHT_YELLOW, DEEP_YELLOW]
// colors1 union colors2: [BLUE, DEEP_YELLOW, YELLOW, LIGHT_BLUE, LIGHT_RED, DEEP_BLUE, DEEP_RED, LIGHT_YELLOW, RED]        
// colors1 intersection colors2: [LIGHT_RED, DEEP_RED, RED]
// colors1 difference colors2: [BLUE, LIGHT_BLUE, DEEP_BLUE]
// colors1 complement colors2: [BLUE, DEEP_YELLOW, YELLOW, LIGHT_BLUE, DEEP_BLUE, LIGHT_YELLOW]