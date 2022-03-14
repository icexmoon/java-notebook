package ch14.cast;

class SimpleStack<T> {
    private Object[] items;
    private int index = 0;

    public SimpleStack(int limit) {
        this.items = new Object[limit];
    }

    public void push(T item) {
        if (index < items.length) {
            items[index] = item;
            index++;
        }
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (index > 0) {
            index--;
            return (T) items[index];
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        SimpleStack<String> ss = new SimpleStack<>(10);
        for (String string : "a b c d e f".split(" ")) {
            ss.push(string);
        }
        do {
            String item = ss.pop();
            if (item == null) {
                break;
            }
            System.out.print(item + " ");
        } while (true);
    }
}
