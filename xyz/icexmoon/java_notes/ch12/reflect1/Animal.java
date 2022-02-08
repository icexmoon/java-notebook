package ch12.reflect1;

class Animal {
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
    public static AnimalFactory factory = new AnimalFactory() {
        public Animal create() {
            return new SportingDog();
        };
    };
}

class WorkingDog extends Dog {
    public static AnimalFactory factory = new AnimalFactory() {
        public Animal create() {
            return new WorkingDog();
        };
    };
}

class HerdingDog extends Dog {
    public static AnimalFactory factory = new AnimalFactory() {
        public Animal create() {
            return new HerdingDog();
        };
    };
}

class PersianCat extends Cat {
    public static AnimalFactory factory = new AnimalFactory() {
        public Animal create(){
            return new PersianCat();
        }
    };
}

class BirmanCat extends Cat {
    public static AnimalFactory factory = new AnimalFactory() {
        public Animal create() {
            return new BirmanCat();
        };
    };
}
