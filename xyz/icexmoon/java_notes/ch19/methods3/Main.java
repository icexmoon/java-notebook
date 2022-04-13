package ch19.methods3;

import java.util.Random;

import util.Fmt;

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

    @Override
    public String toString() {
        return Fmt.sprintf("%s(%s)", name(), des);
    }
}

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            Color c = Color.getRandomColor();
            System.out.println(c);
        }
    }
}
// YELLOW(this is a light color.)
// RED(this is a dack color.)
// RED(this is a dack color.)
// YELLOW(this is a light color.)
// BLUE(default description.)
// BLACK(default description.)