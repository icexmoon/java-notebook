package ch12.cls_counter;

public class Animal {
    @Override
    public String toString() {
        return this.getClass().getCanonicalName();
    }
}

class Cat extends Animal {
}

class Dog extends Animal {
}

class SportingDog extends Dog {
}

class WorkingDog extends Dog {
}

class HerdingDog extends Dog {
}

class PersianCat extends Cat {
}

class BirmanCat extends Cat {
}
