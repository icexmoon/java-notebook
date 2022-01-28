package ch11.format5;

public class Main {

    public static void main(String[] args) {
        char a = 'a';
        System.out.format("%%c:%c\n", a);
        System.out.format("%%d:%d\n", (int) a);
        System.out.format("%%o:%o\n", (int) a);
        System.out.format("%%x:%x\n", (int) a);
    }
}
// %c:a
// %d:97
// %o:141
// %x:61