package ch13.wildcard5;

class GenericClass<T>{
    private T obj;
    public GenericClass(T obj){
        this.obj = obj;
    }
    public void set(T obj){
        this.obj = obj;
    }
    public T get(){
        return this.obj;
    }
}

class Fruit{}
class Apple extends Fruit{}
class RedApple extends Apple{}

public class Main {
    public static void main(String[] args) {
        GenericClass<? super Apple> gc = new GenericClass<Fruit>(new Fruit());
        gc.set(new Apple());
        gc.set(new RedApple());
        // gc.set(new Fruit());
        // Apple apple = gc.get();
        Object obj = gc.get();
    }
}
