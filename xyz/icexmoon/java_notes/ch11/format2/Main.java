package ch11.format2;

import java.util.Formatter;

public class Main {
    public static void main(String[] args) {
        String name = "apple";
        double price = 12.5;
        int num = 15;
        Formatter formatter = new Formatter(System.out);
        formatter.format("name %s, num %d, price %.2f", name, num, price);
    }
}
// name apple, num 15, price 12.50
