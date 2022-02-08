package ch12.generic3;

class MyCls{}

public class Main {
    public static void main(String[] args) {
        Class<MyCls> cls = MyCls.class;
        // cls = Object.class;
        // cls = int.class;
        
    }
}
// Type mismatch: cannot convert from Class<Object> to Class<MyCls>
// Type mismatch: cannot convert from Class<Integer> to Class<MyCls>