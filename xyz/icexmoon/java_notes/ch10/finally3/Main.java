package ch10.finally3;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("now i=" + i);
                if (i == 2) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("finally block is executed.");
            }
        }
        // now i=0
        // finally block is executed.
        // now i=1
        // finally block is executed.
        // now i=2
        // finally block is executed.
    }
}
