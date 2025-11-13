// Abstract class Shape
abstract class Shape {
    int dim1, dim2; // dimensions for the shape

    // Constructor
    Shape(int dim1, int dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    // Abstract method to be implemented by subclasses
    abstract void printArea();
}

// Rectangle class extending Shape
class Rectangle extends Shape {
    Rectangle(int length, int breadth) {
        super(length, breadth);
    }

    @Override
    void printArea() {
        double area = dim1 * dim2;
        System.out.println("Area of Rectangle: " + area);
    }
}

// Triangle class extending Shape
class Triangle extends Shape {
    Triangle(int base, int height) {
        super(base, height);
    }

    @Override
    void printArea() {
        double area = 0.5 * dim1 * dim2;
        System.out.println("Area of Triangle: " + area);
    }
}

// Circle class extending Shap

class Circle extends Shape {
    public Circle(int radius) {
        super(radius, 0); // explicitly call Shape's constructor
    }

    @Override
    public void printArea() {
         System.out.println("Area of Circle:" + (Math.PI * dim1 * dim1));
    }
}



// Main class to test the shapes
public class area {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(10, 5);
        rect.printArea();

        Triangle tri = new Triangle(8, 6);
        tri.printArea();

        Circle circ = new Circle(7);
        circ.printArea();
    }
}