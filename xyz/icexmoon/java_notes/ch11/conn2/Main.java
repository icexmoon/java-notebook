package ch11.conn2;

public class Main {
    public static void main(String[] args) {
        String[] strs = new String[3];
        strs[0] = "hello";
        strs[1] = " world";
        strs[2] = "!";
        String result = String.join("", strs);
        System.out.println(result);
        // hello world!
    }
}
