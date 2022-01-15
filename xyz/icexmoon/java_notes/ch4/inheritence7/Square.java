package ch4.inheritence7;

import util.Fmt;

class Pointer {
    private int x;
    private int y;

    public Pointer(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Pointer(%d,%d)", this.x, this.y);
    }

    public void destory() {
        String thisStr = this.toString();
        this.x = 0;
        this.y = 0;
        Fmt.printf("%s is destroy.\n", thisStr);
    }
}

class Shape {

    public Shape() {
        System.out.println("Shape is build");
    }

    public void desdroy() {
        System.out.println("Shape is destroy.");
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
        Fmt.printf("%s is build.\n", this.getName());
    }

    private String getName() {
        return Fmt.sprintf("Rectangle(xEdge:%s,yEdge:%s,center:%s)", this.xEdge, this.yEdge, this.center);
    }

    @Override
    public void desdroy() {
        String thisStr = this.getName();
        this.xEdge = 0;
        this.yEdge = 0;
        this.center = new Pointer(0, 0);
        Fmt.printf("%s is destory.\n", thisStr);
        super.desdroy();
    }
}

public class Square extends Rectangle {
    private int edge;
    private Pointer center;

    public Square(int edge, Pointer center) {
        super(edge, edge, center);
        this.edge = edge;
        this.center = center;
        Fmt.printf("%s is build.\n", this.getName());
    }

    @Override
    public void desdroy() {
        String thisStr = this.getName();
        this.edge = 0;
        this.center = new Pointer(0, 0);
        Fmt.printf("%s is destory.\n", thisStr);
        super.desdroy();
    }

    private String getName() {
        return Fmt.sprintf("Squre(edge:%d,center:%s)", this.edge, this.center);
    }

    public static void main(String[] args) {
        Pointer center = new Pointer(5, 5);
        int edge = 10;
        Square s = new Square(edge, center);
        s.desdroy();
        // Shape is build
        // Rectangle(xEdge:10,yEdge:10,center:Pointer(5,5)) is build.
        // Squre(edge:10,center:Pointer(5,5)) is build.
        // Squre(edge:10,center:Pointer(5,5)) is destory.
        // Rectangle(xEdge:10,yEdge:10,center:Pointer(5,5)) is destory.
        // Shape is destroy.
    }
}
