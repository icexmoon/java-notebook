package ch4.cast;

import util.Fmt;

public class Line extends Shape {
    private Pointer x;
    private Pointer y;
    private int refCounter;

    public Line(Pointer x, Pointer y) {
        this.x = x;
        x.addReference();
        this.y = y;
        y.addReference();
    }

    public void addReference() {
        this.refCounter++;
    }

    public void display() {
        this.x.display();
        this.y.display();
        Fmt.printf("%s is displayed.\n", this);
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Line(x:%s,y:%s)", this.x, this.y);
    }

    public void destroy() {
        if (refCounter > 0) {
            refCounter--;
            if (refCounter == 0) {
                this.x.destory();
                this.y.destory();
                Fmt.printf("%s is destoryed.\n", this);
            }
        }
    }

}
