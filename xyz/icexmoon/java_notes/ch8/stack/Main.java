package ch8.stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("push " + i);
            stack.push(i);
            System.out.println(stack);
        }
        System.out.println("starting pop stack.");
        while (!stack.empty()) {
            Integer num = stack.pop();
            System.out.println(num + " is poped.");
            System.out.println(stack);
        }
        // push 0
        // [0]
        // push 1
        // [1, 0]
        // push 2
        // [2, 1, 0]
        // push 3
        // [3, 2, 1, 0]
        // push 4
        // [4, 3, 2, 1, 0]
        // starting pop stack.
        // 4 is poped.
        // [3, 2, 1, 0]
        // 3 is poped.
        // [2, 1, 0]
        // 2 is poped.
        // [1, 0]
        // 1 is poped.
        // [0]
        // 0 is poped.
        // []
    }
}
