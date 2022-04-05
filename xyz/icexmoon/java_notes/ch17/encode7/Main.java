package ch17.encode7;

import util.BytesConvert;

public class Main {
    public static void main(String[] args) {
        byte b1 = 0;
        byte b2 = 'H';
        String s1 = BytesConvert.convertByteToBinaryStr(b1);
        String s2 = BytesConvert.convertByteToBinaryStr(b2);
        System.out.println(s1 + s2);
    }
}
