package ch1.switch4;

class MyClass {
    private int number = 0;

    public MyClass(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj instanceof MyClass){
            MyClass other = (MyClass)obj;
            return this.number == other.number;
        }
        return false;
    }

}

public class Main {
    public static void main(String[] args) {
        // MyClass mc1 = new MyClass(1);
        // MyClass mc2 = new MyClass(2);
        // MyClass mc3 = new MyClass(1);
        // switch(mc1){
        //     case mc2:
        //         break;
        //     case mc3:
        //         break;
        //     default:
        // }
    }
}
