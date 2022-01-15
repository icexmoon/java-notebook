package ch2.array4;

public class Main {
    private static void printArr(int[] arr) {
        System.out.print('[');
        for (int num : arr) {
            System.out.print(num + ", ");
        }
        System.out.print(']');
        System.out.println();
    }

    public static void main(String[] args) {
        printArr(new int[] { 1, 2, 3 });
        // [1, 2, 3, ]
    }
}
