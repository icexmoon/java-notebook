package ch11.conn4;

public class Main {
    public static void main(String[] args) {
        String[] strs = new String[] { "hello", "world", "!" };
        String result = "";
        for (String s : strs) {
            String begin = "[";
            String end = "]";
            result += begin + s + end;
        }
        System.out.println(result);
    }
}
