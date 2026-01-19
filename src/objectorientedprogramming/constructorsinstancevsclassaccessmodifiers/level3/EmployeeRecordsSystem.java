
package objectorientedprogramming.constructorsinstancevsclassaccessmodifiers.level3;
class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    // Constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to get salary
    public double getSalary() {
        return salary;
    }

    // Public method to update salary
    public void updateSalary(double newSalary) {
        if (newSalary > 0) {
            this.salary = newSalary;
            System.out.println("Salary updated successfully to: $" + salary);
        } else {
            System.out.println("Invalid salary amount!");
        }
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
        System.out.println("------------------------");
    }
}

class Manager extends Employee {
    int teamSize;
    double bonus;

    // Constructor
    public Manager(int employeeID, String department, double salary, int teamSize, double bonus) {
        super(employeeID, department, salary);
        this.teamSize = teamSize;
        this.bonus = bonus;
    }

    // Method to calculate total compensation
    public double calculateTotalCompensation() {
        return getSalary() + bonus;
    }

    // Method to display manager details
    public void displayManagerDetails() {
        System.out.println("Manager Details:");
        System.out.println("Employee ID: " + employeeID); // public - accessible
        System.out.println("Department: " + department); // protected - accessible in subclass
        System.out.println("Salary: $" + getSalary()); // private - accessed via getter
        System.out.println("Team Size: " + teamSize);
        System.out.println("Bonus: $" + bonus);
        System.out.println("Total Compensation: $" + calculateTotalCompensation());
        System.out.println("------------------------");
    }
}

public class EmployeeRecordsSystem {
    public static void main(String[] args) {
        System.out.println("=== Employee Records System ===\n");

        // Create employee object
        Employee emp = new Employee(101, "IT", 60000.0);
        emp.displayDetails();

        // Access public member directly
        System.out.println("Accessing public member: Employee ID = " + emp.employeeID);

        // Access private member via getter
        System.out.println("Accessing private member via getter: Salary = $" + emp.getSalary());

        // Update salary
        System.out.println("\nUpdating salary:");
        emp.updateSalary(65000.0);
        emp.displayDetails();

        // Create manager object
        System.out.println("\n=== Manager ===");
        Manager manager = new Manager(201, "Engineering", 90000.0, 10, 15000.0);
        manager.displayManagerDetails();

        // Update manager salary
        System.out.println("\nUpdating manager salary:");
        manager.updateSalary(95000.0);
        manager.displayManagerDetails();
    }
}
