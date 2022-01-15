package ch1.data_overflow;

public class Main {
    public static void main(String[] args){
        int maxInt = Integer.MAX_VALUE;
        maxInt += 3;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(maxInt);
        // 2147483647
        // -2147483646
    }
}
