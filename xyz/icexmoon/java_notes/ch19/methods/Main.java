package ch19.methods;

import java.util.Random;

enum Color {
    RED("this is a dack color."), BLUE, YELLOW("this is a light color."), BLACK, WHITE;

    private String des;
    private static Random rand = new Random();

    private Color(String des) {
        this.des = des;
    }

    private Color() {
        this("default description.");
    }

    public String getDes() {
        return this.des;
    }

    public static Color getRandomColor() {
        Color[] colors = values();
        return colors[rand.nextInt(colors.length)];
    }
}

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            Color c = Color.getRandomColor();
            System.out.print(c + " ");
            System.out.println(c.getDes());
        }
    }
}
// BLACK default description.
// BLUE default description.
// WHITE default description.
// BLUE default description.
// WHITE default description.
// YELLOW this is a light color.