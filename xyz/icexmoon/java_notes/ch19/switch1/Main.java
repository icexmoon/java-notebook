package ch19.switch1;

enum TrafficLight {
    RED, YELLOW, GREEN
}

public class Main {
    public static void main(String[] args) {
        TrafficLight tl = TrafficLight.RED;
        StringBuilder sb= new StringBuilder();
        sb.append(tl);
        for (int i = 0; i < 10; i++) {
            tl = turn(tl);
            sb.append("=>");
            sb.append(tl);
        }
        System.out.println(sb.toString());
    }

    private static TrafficLight turn(TrafficLight tl) {
        switch (tl) {
            case RED:
                return TrafficLight.GREEN;
            case GREEN:
                return TrafficLight.YELLOW;
            case YELLOW:
                return TrafficLight.RED;
            default:
                return TrafficLight.RED;
        }
    }
}
// RED=>GREEN=>YELLOW=>RED=>GREEN=>YELLOW=>RED=>GREEN=>YELLOW=>RED=>GREEN
