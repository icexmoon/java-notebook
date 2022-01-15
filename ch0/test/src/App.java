import java.util.Random;

import xyz.icexmoon.java.notes.Add;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Random rand = new Random();
        int a = rand.nextInt(10);
        int b = rand.nextInt(10);
        System.out.println(a+"+"+b+'='+Add.execute(a, b));
    }
}
