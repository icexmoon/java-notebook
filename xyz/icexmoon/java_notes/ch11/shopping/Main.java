package ch11.shopping;

import java.util.ArrayList;
import java.util.List;

class ShoppingDetail {
    String name = "";
    double num;
    double price;

    public ShoppingDetail(String name, double num, double price) {
        this.name = name;
        this.num = num;
        this.price = price;
    }
}

public class Main {
    private static void addDetail(List<ShoppingDetail> details, String name, double num, double price) {
        details.add(new ShoppingDetail(name, num, price));
    }

    public static void main(String[] args) {
        List<ShoppingDetail> details = new ArrayList<>();
        addDetail(details, "apple", 2.5, 6);
        addDetail(details, "banana", 3, 2.5);
        addDetail(details, "toy", 2, 5);
        System.out.format("%-10s %6s %9s\n", "name", "num", "price");
        System.out.format("%-10s %6s %9s\n", "----------", "------", "---------");
        double total = 0;
        for (ShoppingDetail sd : details) {
            System.out.format("%-10s% 7.2f% 10.2f\n", sd.name, sd.num, sd.price);
            total += sd.num * sd.price;
        }
        System.out.format("%-17s%10s\n","-----------------","---------");
        System.out.format("%-10s%17.2f\n", "total", total);
    }
}
// name          num     price
// ---------- ------ ---------
// apple        2.50      6.00
// banana       3.00      2.50
// toy          2.00      5.00
// ----------------- ---------
// total                 32.50
