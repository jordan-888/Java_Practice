
package objectorientedprogramming.classandobject.level1;
class Circle {
    double radius;

    // Constructor to initialize radius
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display area and circumference
    public void displayDetails() {
        System.out.println("Circle with radius: " + radius);
        System.out.println("Area: " + String.format("%.2f", calculateArea()));
        System.out.println("Circumference: " + String.format("%.2f", calculateCircumference()));
        System.out.println("------------------------");
    }
}

public class CircleArea {
    public static void main(String[] args) {
        // Create circle objects
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(10.0);
        Circle circle3 = new Circle(7.5);

        // Display details
        circle1.displayDetails();
        circle2.displayDetails();
        circle3.displayDetails();
    }
}
