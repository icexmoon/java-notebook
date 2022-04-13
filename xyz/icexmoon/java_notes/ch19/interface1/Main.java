package ch19.interface1;

import ch15.test2.Generator;

enum TrafficLight implements Generator<TrafficLight> {
    RED, GREEN, YELLOW;

    @Override
    public TrafficLight next() {
        switch (this) {
            case RED:
                return GREEN;
            case GREEN:
                return YELLOW;
            case YELLOW:
                return RED;
            default:
                return RED;
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Generator<TrafficLight> gen = TrafficLight.RED;
        StringBuilder sb = new StringBuilder();
        sb.append(gen);
        for (int i = 0; i < 10; i++) {
            gen = gen.next();
            sb.append("=>");
            sb.append(gen);
        }
        System.out.println(sb.toString());
    }
}
// RED=>GREEN=>YELLOW=>RED=>GREEN=>YELLOW=>RED=>GREEN=>YELLOW=>RED=>GREEN
