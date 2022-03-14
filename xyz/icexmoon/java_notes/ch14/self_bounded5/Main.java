package ch14.self_bounded5;

class Plane {
}

class FighterPlane extends Plane {
}

class Pilot {
    public void play(Plane p) {
        System.out.println("Pilot play Plane.");
    }
}

class FighterPilot extends Pilot {
    public void play(FighterPlane fp) {
        System.out.println("FighterPilot play FighterPlane.");
    }
}

public class Main {
    public static void main(String[] args) {
        FighterPilot fp = new FighterPilot();
        fp.play(new Plane());
        fp.play(new FighterPlane());
    }
}
// Pilot play Plane.
// FighterPilot play FighterPlane
