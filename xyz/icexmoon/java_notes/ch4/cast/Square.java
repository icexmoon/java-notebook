package ch4.cast;

import util.Fmt;

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
        this.center.destory();
        Fmt.printf("%s is destory.\n", thisStr);
        super.desdroy();
    }

    private String getName() {
        return Fmt.sprintf("Squre(edge:%d,center:%s)", this.edge, this.center);
    }

    @Override
    public void display() {
        super.display();
    }

    public static void main(String[] args) {
        Pointer center = new Pointer(5, 5);
        int edge = 10;
        Square s = new Square(edge, center);
        s.desdroy();
        // Shape is build
        // Rectangle(xEdge:10,yEdge:10,center:Pointer(5,5)) is build.
        // Squre(edge:10,center:Pointer(5,5)) is build.
        // Pointer(5,5) is destroy.
        // Squre(edge:10,center:Pointer(5,5)) is destory.
        // Pointer(0,0) is destroy.
        // Rectangle(xEdge:10,yEdge:10,center:Pointer(0,0)) is destory.
        // Shape is destroy.
    }
}
