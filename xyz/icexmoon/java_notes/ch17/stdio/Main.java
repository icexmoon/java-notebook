package ch17.stdio;

public class Main {
    public static void main(String[] args) {
        System.out.println(System.in.getClass().getSimpleName());
        System.out.println(System.out.getClass().getSimpleName());
        System.out.println(System.err.getClass().getSimpleName());
    }
}
// BufferedInputStream
// PrintStream
// PrintStream