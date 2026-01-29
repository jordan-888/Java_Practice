package datastructures.sortingalgorithms;
import java.util.Arrays;

/**
 * Selection Sort - Sort Exam Scores
 * Problem: A university needs to sort students' exam scores in ascending order.
 * Implement Selection Sort.
 * 
 * Algorithm:
 * 1. Find the minimum element in the array
 * 2. Swap it with the first unsorted element
 * 3. Repeat the process for the remaining elements
 * 
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */
public class SelectionSortExamScores {

    // Selection Sort implementation
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            // Find minimum element in unsorted part
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap minimum element with first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    // Selection Sort with visualization
    public static void selectionSortWithVisualization(int[] scores) {
        int n = scores.length;

        System.out.println("Initial exam scores: " + Arrays.toString(scores));
        System.out.println("\nSorting process:");

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            System.out.printf("\nPass %d:\n", i + 1);
            System.out.println("  Unsorted part: " + Arrays.toString(Arrays.copyOfRange(scores, i, n)));

            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            System.out.printf("  Minimum found: %d at index %d\n", scores[minIndex], minIndex);

            if (minIndex != i) {
                System.out.printf("  Swapping %d and %d\n", scores[i], scores[minIndex]);
                int temp = scores[minIndex];
                scores[minIndex] = scores[i];
                scores[i] = temp;
            } else {
                System.out.println("  No swap needed");
            }

            System.out.println("  After pass: " + Arrays.toString(scores));
        }
    }

    // Student class for more realistic scenario
    static class Student {
        String name;
        int score;
        String rollNumber;

        Student(String name, int score, String rollNumber) {
            this.name = name;
            this.score = score;
            this.rollNumber = rollNumber;
        }

        @Override
        public String toString() {
            return String.format("%s(%s): %d", name, rollNumber, score);
        }
    }

    // Sort Student objects by score
    public static void selectionSortStudents(Student[] students) {
        int n = students.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (students[j].score < students[minIndex].score) {
                    minIndex = j;
                }
            }

            Student temp = students[minIndex];
            students[minIndex] = students[i];
            students[i] = temp;
        }
    }

    // Calculate grade distribution
    private static void printGradeDistribution(int[] scores) {
        int gradeA = 0, gradeB = 0, gradeC = 0, gradeD = 0, gradeF = 0;

        for (int score : scores) {
            if (score >= 90)
                gradeA++;
            else if (score >= 80)
                gradeB++;
            else if (score >= 70)
                gradeC++;
            else if (score >= 60)
                gradeD++;
            else
                gradeF++;
        }

        System.out.println("\n=== Grade Distribution ===");
        System.out.println("A (90-100): " + gradeA + " students");
        System.out.println("B (80-89):  " + gradeB + " students");
        System.out.println("C (70-79):  " + gradeC + " students");
        System.out.println("D (60-69):  " + gradeD + " students");
        System.out.println("F (0-59):   " + gradeF + " students");
    }

    public static void main(String[] args) {
        System.out.println("=== Selection Sort - Exam Scores ===\n");

        // Test case 1 - Random exam scores
        int[] scores1 = { 78, 92, 45, 67, 88, 54, 73, 91, 62, 85 };
        System.out.println("Test Case 1: Random exam scores");
        System.out.println("Original: " + Arrays.toString(scores1));
        selectionSort(scores1);
        System.out.println("Sorted:   " + Arrays.toString(scores1));
        printGradeDistribution(scores1);

        System.out.println("\n" + "=".repeat(50));

        // Test case 2 - With visualization
        int[] scores2 = { 85, 72, 90, 65, 78 };
        System.out.println("\nTest Case 2: Sorting with visualization");
        selectionSortWithVisualization(scores2);

        System.out.println("\n" + "=".repeat(50));

        // Test case 3 - Student objects
        Student[] students = {
                new Student("Alice", 88, "S001"),
                new Student("Bob", 72, "S002"),
                new Student("Charlie", 95, "S003"),
                new Student("David", 65, "S004"),
                new Student("Eve", 82, "S005"),
                new Student("Frank", 78, "S006")
        };

        System.out.println("\nTest Case 3: Sorting Student objects");
        System.out.println("Original students:");
        for (Student student : students) {
            System.out.println("  " + student);
        }

        selectionSortStudents(students);

        System.out.println("\nSorted students (by score):");
        for (Student student : students) {
            System.out.println("  " + student);
        }

        System.out.println("\n" + "=".repeat(50));

        // Test case 4 - All same scores
        int[] scores4 = { 75, 75, 75, 75, 75 };
        System.out.println("\nTest Case 4: All same scores");
        System.out.println("Original: " + Arrays.toString(scores4));
        selectionSort(scores4);
        System.out.println("Sorted:   " + Arrays.toString(scores4));

        System.out.println("\n" + "=".repeat(50));

        // Test case 5 - Perfect scores and failures
        int[] scores5 = { 100, 45, 98, 32, 95, 55, 88, 0, 92 };
        System.out.println("\nTest Case 5: Wide range of scores");
        System.out.println("Original: " + Arrays.toString(scores5));
        selectionSort(scores5);
        System.out.println("Sorted:   " + Arrays.toString(scores5));
        printGradeDistribution(scores5);
    }
}
