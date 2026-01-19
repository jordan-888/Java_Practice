
package objectorientedprogramming.constructorsinstancevsclassaccessmodifiers.level3;
class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    // Constructor
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public method to get CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public method to update CGPA
    public void updateCGPA(double newCGPA) {
        if (newCGPA >= 0.0 && newCGPA <= 10.0) {
            this.CGPA = newCGPA;
            System.out.println("CGPA updated successfully to: " + CGPA);
        } else {
            System.out.println("Invalid CGPA! Must be between 0.0 and 10.0");
        }
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Student Details:");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
        System.out.println("------------------------");
    }
}

class PostgraduateStudent extends Student {
    String researchArea;

    // Constructor
    public PostgraduateStudent(int rollNumber, String name, double CGPA, String researchArea) {
        super(rollNumber, name, CGPA);
        this.researchArea = researchArea;
    }

    // Method to display postgraduate student details
    public void displayPostgradDetails() {
        System.out.println("Postgraduate Student Details:");
        System.out.println("Roll Number: " + rollNumber); // public - accessible
        System.out.println("Name: " + name); // protected - accessible in subclass
        System.out.println("CGPA: " + getCGPA()); // private - accessed via public method
        System.out.println("Research Area: " + researchArea);
        System.out.println("------------------------");
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== University Management System ===\n");

        // Create student object
        Student student = new Student(101, "Alice Johnson", 8.5);
        student.displayDetails();

        // Access public member directly
        System.out.println("Accessing public member: Roll Number = " + student.rollNumber);

        // Access private member via public method
        System.out.println("Accessing private member via getter: CGPA = " + student.getCGPA());

        // Update CGPA
        System.out.println("\nUpdating CGPA:");
        student.updateCGPA(9.0);
        student.displayDetails();

        // Create postgraduate student object
        System.out.println("\n=== Postgraduate Student ===");
        PostgraduateStudent pgStudent = new PostgraduateStudent(201, "Bob Smith", 9.2, "Artificial Intelligence");
        pgStudent.displayPostgradDetails();
    }
}
