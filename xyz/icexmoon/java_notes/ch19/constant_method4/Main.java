package ch19.constant_method4;

import java.util.EnumSet;

import ch19.constant_method4.SmartHome.Device;

class SmartHome {
    private EnumSet<Device> devices = EnumSet.noneOf(Device.class);

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

    enum Device {
        DOOR {
            @Override
            public void action() {
                System.out.println("Open the door.");
            }
        },
        LIGHT {
            @Override
            public void action() {
                System.out.println("Light is on.");
            }
        },
        TV {
            @Override
            public void action() {
                System.out.println("TV is on.");
            }
        },
        PS5 {
            @Override
            public void action() {
                System.out.println("PS5 is on.");
            }
        },
        AIR_CONDITIONER {
            @Override
            public void action() {
                System.out.println("Air conditioner is on, and temperature is 15 degrees Celsius.");
            }
        },
        XBOX;

        public void action() {
            System.out.println("The device " + this.name() + " is not define operation.");
        };
    }
}

public class Main {
    public static void main(String[] args) {
        SmartHome sh = new SmartHome();
        sh.add(Device.LIGHT);
        sh.add(Device.TV);
        sh.add(Device.DOOR);
        sh.execute();
        sh.clear();
        sh.add(Device.PS5);
        sh.add(Device.TV);
        sh.add(Device.AIR_CONDITIONER);
        sh.add(Device.XBOX);
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
// The device XBOX is not define operation.