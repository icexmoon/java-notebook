package ch13.wildcard13;

public class Main {
    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder<String>("hello");
        // printContentType(holder);
        printContentType2(holder);
    }

    private static <T> void printContentType(SimpleHolder<T> holder) {
        T content = holder.get();
        System.out.println(content.getClass().getSimpleName());
    }

    private static void printContentType2(SimpleHolder<?> holder) {
        printContentType(holder);
    }
}
