
package objectorientedprogramming.classandobject.level1;
class Employee {
    String name;
    int id;
    double salary;

    // Constructor to initialize attributes
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: $" + salary);
        System.out.println("------------------------");
    }
}

public class EmployeeDetails {
    public static void main(String[] args) {
        // Create employee objects
        Employee emp1 = new Employee("John Doe", 101, 50000.0);
        Employee emp2 = new Employee("Jane Smith", 102, 60000.0);
        Employee emp3 = new Employee("Bob Johnson", 103, 55000.0);

        // Display employee details
        emp1.displayDetails();
        emp2.displayDetails();
        emp3.displayDetails();
    }
}
