package ch4.cast;

import util.Fmt;

public class Rectangle extends Shape {
    private int xEdge;
    private int yEdge;
    private Pointer center;
    private Line[] lines = new Line[4];
    // private Pointer[] pointers = new Pointer[4];

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
    public void display() {
        super.display();
        Pointer p1 = new Pointer((int) (center.getX() - 0.5 * this.xEdge), (int) (center.getY() - 0.5 * this.yEdge));
        Pointer p2 = new Pointer((int) (center.getX() + 0.5 * this.xEdge), (int) (center.getY() - 0.5 * this.yEdge));
        Pointer p3 = new Pointer((int) (center.getX() + 0.5 * this.xEdge), (int) (center.getY() + 0.5 * this.yEdge));
        Pointer p4 = new Pointer((int) (center.getX() - 0.5 * this.xEdge), (int) (center.getY() + 0.5 * this.yEdge));
        this.lines[0] = new Line(p1, p2);
        this.lines[0].addReference();
        this.lines[1] = new Line(p2, p3);
        this.lines[1].addReference();
        this.lines[2] = new Line(p3, p4);
        this.lines[2].addReference();
        this.lines[3] = new Line(p4, p1);
        this.lines[3].addReference();
        for (Line line : lines) {
            line.display();
        }
    }

    @Override
    public void desdroy() {
        String thisStr = this.getName();
        this.xEdge = 0;
        this.yEdge = 0;
        this.center.destory();
        for (Line line : lines) {
            line.destroy();
        }
        Fmt.printf("%s is destory.\n", thisStr);
        super.desdroy();
    }
}
