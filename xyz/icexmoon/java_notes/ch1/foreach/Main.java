package ch1.foreach;

class Main {

    public static void main(String[] args) {
        char[] chars = { 'a', 'b', 'c', 'd', 'e' };
        for (char c : chars) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
// a b c d e 