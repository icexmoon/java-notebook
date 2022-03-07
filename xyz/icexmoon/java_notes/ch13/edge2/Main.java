package ch13.edge2;

import java.util.ArrayList;
import java.util.List;

class ListMaker<T> {

    public ListMaker() {
    }

    public List<T> create() {
        return new ArrayList<T>();
    }

}

public class Main {
    public static void main(String[] args) {
        ListMaker<String> lm = new ListMaker<>();
        List<String> list = lm.create();
        list.add("Hello");
        list.add("World");
        System.out.println(list);
    }
}
// [Hello, World]