package ch13.compensation;

class GenericClass<T>{
    private final int SIZE = 10;
    public void f(T obj){
        // T instance = new T();
        // if(obj instanceof T){}
        // T[] arr = new T[SIZE];
        T[] arr2 = (T[])new Object[SIZE];
    }
}

public class Main {
    public static void main(String[] args) {
        
    }
}
