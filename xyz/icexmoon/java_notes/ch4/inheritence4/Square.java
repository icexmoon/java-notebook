package ch4.inheritence4;

class Pointer {
    private int x;
    private int y;

    public Pointer(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class Shape {

    public Shape() {
        System.out.println("Shape is build");
    }
}

class Rectangle extends Shape {
    private int xEdge;
    private int yEdge;
    private Pointer center;

    public Rectangle(int xEdge, int yEdge, Pointer center) {
        super();
        this.xEdge = xEdge;
        this.yEdge = yEdge;
        this.center = center;
        System.out.println("Rectangle is build");
    }
}

public class Square extends Rectangle {
    private int edge;
    private Pointer center;

    public Square(int edge, Pointer center) {
        super(edge, edge, center);
        this.edge = edge;
        this.center = center;
        System.out.println("Square is build");
    }

    public static void main(String[] args) {
        Pointer center = new Pointer(0, 0);
        int edge = 10;
        Square s = new Square(edge, center);
        // Shape is build
        // Rectangle is build
        // Square is build
    }
}
