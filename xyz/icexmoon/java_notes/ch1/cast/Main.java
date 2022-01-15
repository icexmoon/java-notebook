package ch1.cast;

public class Main {
    public static void main(String[] args){
        char c = 'a';
        c = (char)(c + 'b');
        System.out.println(c);
        byte b = 1;
        byte b2 = 1;
        b = (byte)(b + b2);
        System.out.println(b);
        short s = 1;
        short s2 = 1;
        s = (short)(s + s2);
        System.out.println(s);
        // ?
        // 2
        // 2
    }
}
