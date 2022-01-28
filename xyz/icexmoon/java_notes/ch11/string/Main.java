package ch11.string;

public class Main {
    private static void checkAndPrint(String str, String regex) {
        System.out.println(str.matches(regex));
    }

    public static void main(String[] args) {
        checkAndPrint("12345", "[0-9]+");
        checkAndPrint("12345", "\\d+");
        checkAndPrint("-12345", "\\d+");
        checkAndPrint("-12345", "-\\d+");
    }
}
// true
// true
// false
// true