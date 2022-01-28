package ch11.format3;

import java.util.Formatter;

public class Main {
    public static void main(String[] args) {
        String name = "apple";
        double price = 12.5;
        int num = 15;
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("name %s, num %d, price %.2f", name, num, price);
        System.out.println(sb.toString());
    }
}
// name apple, num 15, price 12.50
