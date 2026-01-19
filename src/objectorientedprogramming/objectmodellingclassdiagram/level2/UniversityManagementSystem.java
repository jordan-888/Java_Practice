
package objectorientedprogramming.objectmodellingclassdiagram.level2;
import java.util.ArrayList;

class Course {
    String courseName;
    String courseCode;
    Professor assignedProfessor;
    ArrayList<Student> enrolledStudents;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.enrolledStudents = new ArrayList<>();
    }

    public void assignProfessor(Professor professor) {
        this.assignedProfessor = professor;
        professor.addCourse(this);
        System.out.println("Professor " + professor.name + " assigned to " + courseName);
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void displayCourseInfo() {
        System.out.println("\nCourse: " + courseName + " (" + courseCode + ")");
        System.out.println("Professor: " + (assignedProfessor != null ? assignedProfessor.name : "Not Assigned"));
        System.out.println("Enrolled Students: " + enrolledStudents.size());
        for (Student student : enrolledStudents) {
            System.out.println("  - " + student.name);
        }
    }
}

class Student {
    String name;
    String studentId;
    ArrayList<Course> enrolledCourses;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.enrolledCourses = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        course.enrollStudent(this);
        System.out.println(name + " enrolled in " + course.courseName);
    }

    public void displayEnrolledCourses() {
        System.out.println("\nStudent: " + name + " (" + studentId + ")");
        System.out.println("Enrolled Courses:");
        for (Course course : enrolledCourses) {
            System.out.println("  - " + course.courseName);
        }
    }
}

class Professor {
    String name;
    String professorId;
    String department;
    ArrayList<Course> teachingCourses;

    public Professor(String name, String professorId, String department) {
        this.name = name;
        this.professorId = professorId;
        this.department = department;
        this.teachingCourses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        teachingCourses.add(course);
    }

    public void displayTeachingCourses() {
        System.out.println("\nProfessor: " + name + " (" + department + ")");
        System.out.println("Teaching Courses:");
        for (Course course : teachingCourses) {
            System.out.println("  - " + course.courseName);
        }
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== University Management System ===\n");

        // Create Professors
        Professor prof1 = new Professor("Dr. Alice Johnson", "P001", "Computer Science");
        Professor prof2 = new Professor("Dr. Bob Smith", "P002", "Mathematics");

        // Create Courses
        Course course1 = new Course("Data Structures", "CS201");
        Course course2 = new Course("Algorithms", "CS301");
        Course course3 = new Course("Calculus", "MATH101");

        // Assign professors to courses
        System.out.println("Assigning Professors:");
        course1.assignProfessor(prof1);
        course2.assignProfessor(prof1);
        course3.assignProfessor(prof2);

        // Create Students
        Student student1 = new Student("Emma Wilson", "S001");
        Student student2 = new Student("Liam Brown", "S002");
        Student student3 = new Student("Olivia Davis", "S003");

        // Students enroll in courses
        System.out.println("\nStudent Enrollment:");
        student1.enrollCourse(course1);
        student1.enrollCourse(course2);
        student1.enrollCourse(course3);

        student2.enrollCourse(course1);
        student2.enrollCourse(course3);

        student3.enrollCourse(course2);

        // Display information
        prof1.displayTeachingCourses();
        prof2.displayTeachingCourses();

        student1.displayEnrolledCourses();
        student2.displayEnrolledCourses();

        course1.displayCourseInfo();
        course2.displayCourseInfo();
    }
}
