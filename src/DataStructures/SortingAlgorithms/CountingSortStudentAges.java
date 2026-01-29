package datastructures.sortingalgorithms;
import java.util.Arrays;

/**
 * Counting Sort - Sort Student Ages
 * Problem: A school collects students' ages (ranging from 10 to 18) and wants
 * them sorted.
 * Implement Counting Sort for this task.
 * 
 * Algorithm:
 * 1. Create a count array to store the frequency of each age
 * 2. Compute cumulative frequencies to determine positions
 * 3. Place elements in their correct positions in the output array
 * 
 * Time Complexity: O(n + k) where k is the range of input
 * Space Complexity: O(k)
 */
public class CountingSortStudentAges {

    // Counting Sort implementation
    public static void countingSort(int[] ages) {
        if (ages.length == 0)
            return;

        // Find the range of ages
        int min = ages[0];
        int max = ages[0];
        for (int age : ages) {
            if (age < min)
                min = age;
            if (age > max)
                max = age;
        }

        int range = max - min + 1;

        // Create count array
        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Store count of each age
        for (int age : ages) {
            count[age - min]++;
        }

        // Change count[i] to contain actual position of this age in output
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }

        // Copy output array to ages
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    // Counting Sort with visualization
    public static void countingSortWithVisualization(int[] ages) {
        if (ages.length == 0)
            return;

        System.out.println("Initial ages: " + Arrays.toString(ages));

        int min = ages[0];
        int max = ages[0];
        for (int age : ages) {
            if (age < min)
                min = age;
            if (age > max)
                max = age;
        }

        int range = max - min + 1;
        int[] count = new int[range];

        // Count frequencies
        System.out.println("\nStep 1: Counting frequencies");
        for (int age : ages) {
            count[age - min]++;
        }

        System.out.println("Age\tCount");
        System.out.println("---\t-----");
        for (int i = 0; i < range; i++) {
            if (count[i] > 0) {
                System.out.printf("%d\t%d\n", i + min, count[i]);
            }
        }

        // Cumulative count
        System.out.println("\nStep 2: Computing cumulative counts");
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Build output
        int[] output = new int[ages.length];
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }

        System.arraycopy(output, 0, ages, 0, ages.length);
        System.out.println("\nStep 3: Final sorted array");
        System.out.println(Arrays.toString(ages));
    }

    // Student class for more realistic scenario
    static class Student {
        String name;
        int age;
        String grade;

        Student(String name, int age, String grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return String.format("%s (Age: %d, Grade: %s)", name, age, grade);
        }
    }

    // Sort Student objects by age using counting sort
    public static void countingSortStudents(Student[] students) {
        if (students.length == 0)
            return;

        int min = students[0].age;
        int max = students[0].age;
        for (Student student : students) {
            if (student.age < min)
                min = student.age;
            if (student.age > max)
                max = student.age;
        }

        int range = max - min + 1;
        int[] count = new int[range];
        Student[] output = new Student[students.length];

        for (Student student : students) {
            count[student.age - min]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = students.length - 1; i >= 0; i--) {
            output[count[students[i].age - min] - 1] = students[i];
            count[students[i].age - min]--;
        }

        System.arraycopy(output, 0, students, 0, students.length);
    }

    // Print age distribution
    private static void printAgeDistribution(int[] ages) {
        int[] count = new int[20]; // Assuming ages 0-19

        for (int age : ages) {
            if (age < 20)
                count[age]++;
        }

        System.out.println("\n=== Age Distribution ===");
        for (int i = 0; i < 20; i++) {
            if (count[i] > 0) {
                System.out.printf("Age %d: %d student(s) ", i, count[i]);
                for (int j = 0; j < count[i]; j++) {
                    System.out.print("█");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Counting Sort - Student Ages ===\n");

        // Test case 1 - Random student ages
        int[] ages1 = { 15, 12, 17, 14, 16, 13, 15, 18, 14, 16, 12, 17 };
        System.out.println("Test Case 1: Random student ages");
        System.out.println("Original: " + Arrays.toString(ages1));
        countingSort(ages1);
        System.out.println("Sorted:   " + Arrays.toString(ages1));
        printAgeDistribution(ages1);

        System.out.println("\n" + "=".repeat(50));

        // Test case 2 - With visualization
        int[] ages2 = { 16, 14, 15, 13, 17, 14, 16 };
        System.out.println("\nTest Case 2: Sorting with visualization");
        countingSortWithVisualization(ages2);

        System.out.println("\n" + "=".repeat(50));

        // Test case 3 - Student objects
        Student[] students = {
                new Student("Alice", 15, "10th"),
                new Student("Bob", 12, "7th"),
                new Student("Charlie", 17, "12th"),
                new Student("Diana", 14, "9th"),
                new Student("Eve", 16, "11th"),
                new Student("Frank", 13, "8th"),
                new Student("Grace", 15, "10th"),
                new Student("Henry", 18, "12th")
        };

        System.out.println("\nTest Case 3: Sorting Student objects");
        System.out.println("Original students:");
        for (Student student : students) {
            System.out.println("  " + student);
        }

        countingSortStudents(students);

        System.out.println("\nSorted students (by age):");
        for (Student student : students) {
            System.out.println("  " + student);
        }

        System.out.println("\n" + "=".repeat(50));

        // Test case 4 - All same age
        int[] ages4 = { 15, 15, 15, 15, 15 };
        System.out.println("\nTest Case 4: All same age");
        System.out.println("Original: " + Arrays.toString(ages4));
        countingSort(ages4);
        System.out.println("Sorted:   " + Arrays.toString(ages4));

        System.out.println("\n" + "=".repeat(50));

        // Test case 5 - Large dataset
        int[] ages5 = { 14, 16, 12, 15, 17, 13, 18, 14, 16, 15, 12, 17,
                14, 15, 16, 13, 15, 14, 16, 17 };
        System.out.println("\nTest Case 5: Large dataset");
        System.out.println("Original: " + Arrays.toString(ages5));
        countingSort(ages5);
        System.out.println("Sorted:   " + Arrays.toString(ages5));
        printAgeDistribution(ages5);
    }
}
