package ch11.conn3;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.append(" world");
        sb.append("!");
        String result = sb.toString();
        System.out.println(result);
        // hello world!
    }
}
