
package objectorientedprogramming.objectmodellingclassdiagram.level2;
import java.util.ArrayList;

class Faculty {
    String name;
    String facultyId;
    String specialization;

    public Faculty(String name, String facultyId, String specialization) {
        this.name = name;
        this.facultyId = facultyId;
        this.specialization = specialization;
    }

    public void displayDetails() {
        System.out.println("  Faculty: " + name + " (" + facultyId + ") - " + specialization);
    }
}

class Department {
    String departmentName;
    ArrayList<Faculty> facultyMembers;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.facultyMembers = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    public void displayDepartment() {
        System.out.println("\nDepartment: " + departmentName);
        System.out.println("Faculty Members:");
        for (Faculty faculty : facultyMembers) {
            faculty.displayDetails();
        }
    }
}

class University {
    String universityName;
    ArrayList<Department> departments;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
    }

    public Department createDepartment(String departmentName) {
        Department dept = new Department(departmentName);
        departments.add(dept);
        return dept;
    }

    public void displayUniversity() {
        System.out.println("\n=== University: " + universityName + " ===");
        System.out.println("Total Departments: " + departments.size());
        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }

    public void closeUniversity() {
        System.out.println("\nClosing " + universityName + "...");
        departments.clear();
        System.out.println("All departments removed (Composition)");
        System.out.println("Faculty members still exist independently (Aggregation)");
    }
}

public class UniversityFacultyDepartment {
    public static void main(String[] args) {
        System.out.println("=== University with Faculties and Departments ===\n");

        // Create University
        University university = new University("State University");

        // Create Faculty members independently (Aggregation)
        Faculty faculty1 = new Faculty("Dr. Alice Johnson", "F001", "Computer Science");
        Faculty faculty2 = new Faculty("Dr. Bob Smith", "F002", "Mathematics");
        Faculty faculty3 = new Faculty("Dr. Charlie Brown", "F003", "Physics");
        Faculty faculty4 = new Faculty("Dr. Diana Prince", "F004", "Chemistry");

        // Create Departments (Composition - departments belong to university)
        Department csDept = university.createDepartment("Computer Science");
        Department mathDept = university.createDepartment("Mathematics");
        Department scienceDept = university.createDepartment("Science");

        // Add faculty to departments (Aggregation - faculty can exist independently)
        csDept.addFaculty(faculty1);
        mathDept.addFaculty(faculty2);
        scienceDept.addFaculty(faculty3);
        scienceDept.addFaculty(faculty4);

        // Display university structure
        university.displayUniversity();

        // Close university (departments deleted, faculty still exists)
        university.closeUniversity();

        System.out.println("\nFaculty members still exist:");
        faculty1.displayDetails();
        faculty2.displayDetails();
    }
}
