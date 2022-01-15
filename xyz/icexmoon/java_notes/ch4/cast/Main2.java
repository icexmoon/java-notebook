package ch4.cast;

public class Main2 {
    private static void testShape(Shape shape) {
        shape.display();
        shape.desdroy();
    }

    public static void main(String[] args) {
        Pointer center = new Pointer(5, 5);
        int edge = 10;
        Shape s = new Square(edge, center);
        testShape(s);
    }
}
