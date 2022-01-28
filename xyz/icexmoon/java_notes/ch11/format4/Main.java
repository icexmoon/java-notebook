package ch11.format4;

public class Main {
    public static void main(String[] args) {
        String name = "apple";
        double price = 12.5;
        int num = 15;
        String result = String.format("name %s, num %d, price %.2f", name, num, price);
        System.out.println(result);
    }
}
// name apple, num 15, price 12.50
