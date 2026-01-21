package DataStructures.LinkedList;

import java.util.Scanner;

class StudentNode {
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;

    public StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private StudentNode head;

    public StudentLinkedList() {
        this.head = null;
    }

    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        // Step 1: Create new node
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);

        // Step 2: Point new node to current head
        newNode.next = head;

        // Step 3: Update head to new node
        head = newNode;

        System.out.println("✓ Student added at the beginning successfully!");
    }

    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        // Step 1: Create new node
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);

        // Step 2: If list is empty, make new node the head
        if (head == null) {
            head = newNode;
            System.out.println("✓ Student added as the first record!");
            return;
        }

        // Step 3: Traverse to the last node
        StudentNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Step 4: Link last node to new node
        current.next = newNode;

        System.out.println("✓ Student added at the end successfully!");
    }

    public void addAtPosition(int rollNumber, String name, int age, String grade, int position) {
        // Step 1: Validate position
        if (position < 1) {
            System.out.println("✗ Invalid position! Position must be >= 1");
            return;
        }

        // Step 2: Create new node
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);

        // Step 3: If position is 1, add at beginning
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            System.out.println("✓ Student added at position " + position + " successfully!");
            return;
        }

        // Step 4: Traverse to position-1
        StudentNode current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        // Step 5: Check if position is valid
        if (current == null) {
            System.out.println("✗ Position out of bounds! List has fewer elements.");
            return;
        }

        // Step 6: Insert new node
        newNode.next = current.next;
        current.next = newNode;

        System.out.println("✓ Student added at position " + position + " successfully!");
    }

    public void deleteByRollNumber(int rollNumber) {
        // Step 1: Check if list is empty
        if (head == null) {
            System.out.println("✗ List is empty! No records to delete.");
            return;
        }

        // Step 2: If head node is to be deleted
        if (head.rollNumber == rollNumber) {
            System.out.println("✓ Deleted student: " + head.name + " (Roll No: " + rollNumber + ")");
            head = head.next;
            return;
        }

        // Step 3: Traverse to find node before the target
        StudentNode current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }

        // Step 4: Check if student was found
        if (current.next == null) {
            System.out.println("✗ Student with Roll Number " + rollNumber + " not found!");
            return;
        }

        // Step 5: Delete by skipping the node
        System.out.println("✓ Deleted student: " + current.next.name + " (Roll No: " + rollNumber + ")");
        current.next = current.next.next;
    }

    public void searchByRollNumber(int rollNumber) {
        StudentNode current = head;
        int position = 1;

        // Traverse and search
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                System.out.println("\n========== Student Found ==========");
                System.out.println("Position      : " + position);
                System.out.println("Roll Number   : " + current.rollNumber);
                System.out.println("Name          : " + current.name);
                System.out.println("Age           : " + current.age);
                System.out.println("Grade         : " + current.grade);
                System.out.println("===================================\n");
                return;
            }
            current = current.next;
            position++;
        }

        System.out.println("✗ Student with Roll Number " + rollNumber + " not found!");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("✗ No student records available!");
            return;
        }

        System.out.println("\n========== All Student Records ==========");
        System.out.printf("%-10s %-20s %-5s %-10s%n", "Roll No", "Name", "Age", "Grade");
        System.out.println("--------------------------------------------------");

        StudentNode current = head;
        while (current != null) {
            System.out.printf("%-10d %-20s %-5d %-10s%n",
                    current.rollNumber, current.name, current.age, current.grade);
            current = current.next;
        }
        System.out.println("==========================================\n");
    }

    public void updateGrade(int rollNumber, String newGrade) {
        StudentNode current = head;

        // Traverse and update
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                String oldGrade = current.grade;
                current.grade = newGrade;
                System.out.println("✓ Updated grade for " + current.name +
                        " (Roll No: " + rollNumber + ") from '" + oldGrade + "' to '" + newGrade + "'");
                return;
            }
            current = current.next;
        }

        System.out.println("✗ Student with Roll Number " + rollNumber + " not found!");
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentLinkedList studentList = new StudentLinkedList();

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   Student Record Management System         ║");
        System.out.println("║   Using Singly Linked List                 ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        while (true) {
            System.out.println("┌─────────────────────────────────────┐");
            System.out.println("│          MENU OPTIONS               │");
            System.out.println("├─────────────────────────────────────┤");
            System.out.println("│ 1. Add Student at Beginning         │");
            System.out.println("│ 2. Add Student at End               │");
            System.out.println("│ 3. Add Student at Specific Position │");
            System.out.println("│ 4. Delete Student by Roll Number    │");
            System.out.println("│ 5. Search Student by Roll Number    │");
            System.out.println("│ 6. Display All Students             │");
            System.out.println("│ 7. Update Student Grade             │");
            System.out.println("│ 8. Exit                             │");
            System.out.println("└─────────────────────────────────────┘");
            System.out.print("Enter your choice (1-8): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Add Student at Beginning ---");
                    System.out.print("Enter Roll Number: ");
                    int rollNo1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name1 = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Grade (A/B/C/D/F): ");
                    String grade1 = scanner.nextLine();
                    studentList.addAtBeginning(rollNo1, name1, age1, grade1);
                    break;

                case 2:
                    System.out.println("\n--- Add Student at End ---");
                    System.out.print("Enter Roll Number: ");
                    int rollNo2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name2 = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Grade (A/B/C/D/F): ");
                    String grade2 = scanner.nextLine();
                    studentList.addAtEnd(rollNo2, name2, age2, grade2);
                    break;

                case 3:
                    System.out.println("\n--- Add Student at Specific Position ---");
                    System.out.print("Enter Roll Number: ");
                    int rollNo3 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name3 = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age3 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Grade (A/B/C/D/F): ");
                    String grade3 = scanner.nextLine();
                    System.out.print("Enter Position (1 for first, 2 for second, etc.): ");
                    int position = scanner.nextInt();
                    studentList.addAtPosition(rollNo3, name3, age3, grade3, position);
                    break;

                case 4:
                    System.out.println("\n--- Delete Student ---");
                    System.out.print("Enter Roll Number to delete: ");
                    int rollNoDelete = scanner.nextInt();
                    studentList.deleteByRollNumber(rollNoDelete);
                    break;

                case 5:
                    System.out.println("\n--- Search Student ---");
                    System.out.print("Enter Roll Number to search: ");
                    int rollNoSearch = scanner.nextInt();
                    studentList.searchByRollNumber(rollNoSearch);
                    break;

                case 6:
                    studentList.displayAll();
                    break;

                case 7:
                    System.out.println("\n--- Update Student Grade ---");
                    System.out.print("Enter Roll Number: ");
                    int rollNoUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Grade (A/B/C/D/F): ");
                    String newGrade = scanner.nextLine();
                    studentList.updateGrade(rollNoUpdate, newGrade);
                    break;

                case 8:
                    System.out.println("\n✓ Thank you for using Student Record Management System!");
                    System.out.println("✓ Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("✗ Invalid choice! Please enter a number between 1-8.");
            }

            System.out.println();
        }
    }
}
