import java.util.Scanner;

// Step 1: Define the interface
interface Polygon {
    double area();
    double perimeter();
}

class Triangle implements Polygon {
    protected double side1, side2, side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    @Override
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(Math.max(0, s * (s-side1) * (s-side2) * (s-side3))); 
    }

    public double perimeter () {
        return side1 + side2 + side3;
    }
}

// Step 2: Implement a base class for a specific shape
class Quadrilateral implements Polygon {
    // What attributes do all quadrilaterals have?
    // ...
    protected double side1, side2, side3, side4;
    
    public Quadrilateral(double side1, double side2, double side3, double side4) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
    }

    @Override
    public double area() {
        // To be implemented by subclasses
        return 0;
    }

    @Override
    public double perimeter() {
        // To be implemented by subclasses
        return side1 + side2 + side3 + side4;
    }
}

class Pentagon implements Polygon {
    private final double side;
    public Pentagon(double side) {
        this.side = side;
    }
    @Override
    public double area() {
        return (5 * side * side) / (4 * Math.tan(Math.PI / 5));
    }

    @Override
    public double perimeter() {
        return 5 * side;
    }
}

class Hexagon implements Polygon {
    private final double side;
    public Hexagon(double side) {
        this.side = side;
    }
    @Override
    public double area() {
        return (6 * side * side) / (4 * Math.tan(Math.PI / 6));
    }

    @Override
    public double perimeter() {
        return 6 * side;
    }
}

class Octagon implements Polygon {
    private final double side;
    public Octagon(double side) {
        this.side = side;
    }
    @Override
    public double area() {
        return (8 * side * side) / (4 * Math.tan(Math.PI / 8));
    }

    @Override
    public double perimeter() {
        return 8 * side;
    }
}

// Step 3: Create a subclass using inheritance
class Rectangle extends Quadrilateral {
    protected double length;
    protected double width; // I would put this as protected double length, width; but wasn't sure if I was allowed to change it.

    public Rectangle(double length, double width) {
        super(length, width, length, width);
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
    // You implement the perimeter method...
}

// Step 4: Create a more specific subclass
class Square extends Rectangle {
    public Square(double side) {
        // How do you call the Rectangle constructor from here? I am not sure
        super(side, side);
    }
}

class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double equalSide, double base) {
        super(equalSide, equalSide, base);
    }
}

class EquilateralTriangle extends IsoscelesTriangle {
    public EquilateralTriangle(double side) {
        super(side, side);
    }
}

// Main class for user interface
public class PolygonCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create a polygon:");
        // Your UI logic here...
        System.out.println("Choose one 1) Triangle \n 2) IsoscelesTriangle \n" + 
        "3) EquilateralTriangle\n4) Quadrilateral\n5) Rectangle\n6) Square\n7) Pentagon\n" +
        "8) Hexagon\n9) Octagon");
        System.out.print("Enter choice (1-9): ");
        int choice = scanner.nextInt();

        Polygon shape = null;

        switch (choice) {
            case 1 -> {
                System.out.print("Enter three sides: ");
                shape = new Triangle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
            }
            case 2 -> {
                System.out.print("Enter equal side and base: ");
                shape = new IsoscelesTriangle(scanner.nextDouble(), scanner.nextDouble());
            }
            case 3 -> {
                System.out.print("Enter side: ");
                shape = new EquilateralTriangle(scanner.nextDouble());
            }
            case 4 -> {
                System.out.print("Enter four sides: ");
                shape = new Quadrilateral(scanner.nextDouble(), scanner.nextDouble(),
                                          scanner.nextDouble(), scanner.nextDouble());
            }
            case 5 -> {
                System.out.print("Enter length and width: ");
                shape = new Rectangle(scanner.nextDouble(), scanner.nextDouble());
            }
            case 6 -> {
                System.out.print("Enter side: ");
                shape = new Square(scanner.nextDouble());
            }
            case 7 -> {
                System.out.print("Enter side: ");
                shape = new Pentagon(scanner.nextDouble());
            }
            case 8 -> {
                System.out.print("Enter side: ");
                shape = new Hexagon(scanner.nextDouble());
            }
            case 9 -> {
                System.out.print("Enter side: ");
                shape = new Octagon(scanner.nextDouble());
            }
            default -> System.out.println("Invalid choice.");
        }

        if (shape != null) {
            System.out.printf("Perimeter = %.4f%n", shape.perimeter());
            System.out.printf("Area      = %.4f%n", shape.area());
        }
    }
}
