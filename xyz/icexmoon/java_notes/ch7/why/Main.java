package ch7.why;

class BaseA{}

class BaseB{}

class MyClass extends BaseA{
    public BaseB getBaseB(){
        return new BaseB();
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass mc = new MyClass();
        BaseB bb = mc.getBaseB();
        BaseA ba = mc;
    }
}
