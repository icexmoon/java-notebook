package ch11.conn5;

public class Main {
    public static void main(String[] args) {
        String[] strs = new String[] { "hello", "world", "!" };
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            String begin = "[";
            String end = "]";
            sb.append(begin);
            sb.append(s);
            sb.append(end);
        }
        String result = sb.toString();
        System.out.println(result);
    }
}
