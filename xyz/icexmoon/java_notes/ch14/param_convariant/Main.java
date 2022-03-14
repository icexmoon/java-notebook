package ch14.param_convariant;

class Base<T>{
    public void set(T t){
        System.out.println("Base's func set is called.");
    }
}


class Sub extends Base<Sub>{
    @Override
    public void set(Sub t) {
        System.out.println("Sub's func set is called.");
    }
}

public class Main {
    public static void main(String[] args) {
        Base<Object> b = new Base<>();
        b.set(b);
        Sub s = new Sub();
        s.set(s);
        // s.set(b);
    }
}
