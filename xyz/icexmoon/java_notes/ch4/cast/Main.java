package ch4.cast;

public class Main {
    private static void testShape(Shape shape) {
        shape.display();
        shape.desdroy();
    }

    public static void main(String[] args) {
        Pointer center = new Pointer(5, 5);
        int edge = 10;
        Square s = new Square(edge, center);
        Shape[] shapes = new Shape[3];
        shapes[0] = s;
        shapes[1] = center;
        shapes[2] = new Line(new Pointer(5, 5), new Pointer(1, 1));
        for (Shape shape : shapes) {
            testShape(shape);
        }
    }
}
