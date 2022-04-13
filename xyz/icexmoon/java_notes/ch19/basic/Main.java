package ch19.basic;

import util.Fmt;

enum Color {
    RED, BLUE, GREEN, YELLO, BLACK
}

public class Main {
    public static void main(String[] args) {
        Color comparedColor = Color.GREEN;
        for (Color color : Color.values()) {
            System.out.print(color + "\t");
            System.out.print("#" + color.ordinal() + "\t");
            String flag = "";
            int compare = color.compareTo(comparedColor);
            if (compare < 0) {
                flag = "<";
            } else if (compare == 0) {
                flag = "=";
            } else {
                flag = ">";
            }
            Fmt.printf("%s %s %s\t", color, flag, comparedColor);
            if (color == comparedColor) {
                flag = "=";
            } else {
                flag = "!=";
            }
            Fmt.printf("%s %s %s\t", color, flag, comparedColor);
            if (color.equals(comparedColor)) {
                flag = "=";
            } else {
                flag = "!=";
            }
            Fmt.printf("%s %s %s\t", color, flag, comparedColor);
            System.out.print(color.name() + "\t");
            System.out.print(color.getDeclaringClass());
            System.out.println();
        }
        Color c = Enum.valueOf(Color.class, "RED");
        System.out.println(c);
    }
}
// RED     #0      RED < GREEN     RED != GREEN    RED != GREEN    RED     class ch19.basic.Color
// BLUE    #1      BLUE < GREEN    BLUE != GREEN   BLUE != GREEN   BLUE    class ch19.basic.Color
// GREEN   #2      GREEN = GREEN   GREEN = GREEN   GREEN = GREEN   GREEN   class ch19.basic.Color
// YELLO   #3      YELLO > GREEN   YELLO != GREEN  YELLO != GREEN  YELLO   class ch19.basic.Color
// BLACK   #4      BLACK > GREEN   BLACK != GREEN  BLACK != GREEN  BLACK   class ch19.basic.Color
// RED