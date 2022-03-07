package ch13.generator;

import util.Fmt;

class Animal {
    private static int num = 0;
    private final int id = num++;

    @Override
    public String toString() {
        String clsName = this.getClass().getSimpleName();
        return Fmt.sprintf("%d#%s", id, clsName);
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
