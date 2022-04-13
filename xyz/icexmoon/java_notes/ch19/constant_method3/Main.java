package ch19.constant_method3;

import java.util.SortedSet;
import java.util.TreeSet;

class SmartHome {
    public interface Actionable {
        void action();
    }

    private static abstract class Device implements Comparable<Device>, Actionable {

        private int order;

        public Device(int order) {
            this.order = order;
        }

        @Override
        public int compareTo(Device o) {
            return Integer.compare(this.order, o.order);
        }

    }

    public static final Device DOOR = new Device(0) {
        public void action() {
            System.out.println("Open the door.");
        }
    };
    public static final Device LIGHT = new Device(1) {
        public void action() {
            System.out.println("Light is on.");
        }
    };
    public static final Device TV = new Device(2) {
        public void action() {
            System.out.println("TV is on.");
        };
    };
    public static final Device PS5 = new Device(3) {
        public void action() {
            System.out.println("PS5 is on.");
        };
    };
    public static final Device AIR_CONDITIONER = new Device(4) {
        public void action() {
            System.out.println("Air conditioner is on, and temperature is 15 degrees Celsius.");
        };
    };

    private SortedSet<Device> devices = new TreeSet<>();

    public void add(Device device) {
        devices.add(device);
    }

    public void clear() {
        devices.clear();
    }

    public void execute() {
        System.out.println("begin smark home system...");
        for (Device device : devices) {
            device.action();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SmartHome sh = new SmartHome();
        sh.add(SmartHome.TV);
        sh.add(SmartHome.LIGHT);
        sh.add(SmartHome.DOOR);
        sh.execute();
        sh.clear();
        sh.add(SmartHome.PS5);
        sh.add(SmartHome.AIR_CONDITIONER);
        sh.add(SmartHome.TV);
        sh.execute();
    }
}
// begin smark home system...
// Open the door.
// Light is on.
// TV is on.
// begin smark home system...
// TV is on.
// PS5 is on.
// Air conditioner is on, and temperature is 15 degrees Celsius.