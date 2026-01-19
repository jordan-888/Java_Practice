
package objectorientedprogramming.objectmodellingclassdiagram.level2;
import java.util.ArrayList;

class Course {
    String courseName;
    String courseCode;
    ArrayList<Student> enrolledStudents;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.enrolledStudents = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void displayEnrolledStudents() {
        System.out.println("\nCourse: " + courseName + " (" + courseCode + ")");
        System.out.println("Enrolled Students:");
        for (Student student : enrolledStudents) {
            System.out.println("  - " + student.name + " (" + student.studentId + ")");
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

    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        course.enrollStudent(this);
        System.out.println(name + " enrolled in " + course.courseName);
    }

    public void viewEnrolledCourses() {
        System.out.println("\nStudent: " + name + " (" + studentId + ")");
        System.out.println("Enrolled Courses:");
        for (Course course : enrolledCourses) {
            System.out.println("  - " + course.courseName + " (" + course.courseCode + ")");
        }
    }
}

class School {
    String schoolName;
    ArrayList<Student> students;
    ArrayList<Course> courses;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displaySchoolInfo() {
        System.out.println("\n=== " + schoolName + " ===");
        System.out.println("Total Students: " + students.size());
        System.out.println("Total Courses: " + courses.size());
    }
}

public class SchoolStudentCourse {
    public static void main(String[] args) {
        System.out.println("=== School, Students, and Courses ===\n");

        // Create School
        School school = new School("Springfield High School");

        // Create Students (Aggregation - students can exist independently)
        Student student1 = new Student("Alice Johnson", "S001");
        Student student2 = new Student("Bob Smith", "S002");
        Student student3 = new Student("Charlie Brown", "S003");

        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);

        // Create Courses
        Course course1 = new Course("Mathematics", "MATH101");
        Course course2 = new Course("Physics", "PHY101");
        Course course3 = new Course("Computer Science", "CS101");

        school.addCourse(course1);
        school.addCourse(course2);
        school.addCourse(course3);

        // Students enroll in courses (Many-to-Many Association)
        System.out.println("Enrollment Process:");
        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student1.enrollInCourse(course3);

        student2.enrollInCourse(course1);
        student2.enrollInCourse(course3);

        student3.enrollInCourse(course2);
        student3.enrollInCourse(course3);

        // Display school info
        school.displaySchoolInfo();

        // Students view their courses
        student1.viewEnrolledCourses();
        student2.viewEnrolledCourses();

        // Courses display enrolled students
        course1.displayEnrolledStudents();
        course3.displayEnrolledStudents();
    }
}
