package ch4.cast;

import util.Fmt;

public class Pointer extends Shape {

    private int x;
    private int y;
    private int refCounter;

    public Pointer(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void addReference() {
        this.refCounter++;
    }

    public void display() {
        Fmt.printf("Pointer(%s) is displayed.\n", this);
    }

    @Override
    public String toString() {
        return Fmt.sprintf("Pointer(%d,%d)", this.x, this.y);
    }

    public void destory() {
        if (this.refCounter > 0) {
            this.refCounter--;
            if (this.refCounter == 0) {
                String thisStr = this.toString();
                this.x = 0;
                this.y = 0;
                Fmt.printf("%s is destroy.\n", thisStr);
            }
        }
    }
}
