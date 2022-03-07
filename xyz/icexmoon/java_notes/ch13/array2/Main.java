package ch13.array2;

import java.util.ArrayList;
import java.util.List;

class GenericClass<T>{}

public class Main {
    public static void main(String[] args) {
        List<GenericClass<String>> arr = new ArrayList<>();
    }
}
