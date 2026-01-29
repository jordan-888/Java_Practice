package datastructures.sortingalgorithms;
import java.util.Arrays;

/**
 * Bubble Sort - Sort Student Marks
 * Problem: A school maintains student marks in an array. Implement Bubble Sort
 * to sort the marks in ascending order.
 * 
 * Algorithm:
 * 1. Traverse through the array multiple times
 * 2. Compare adjacent elements and swap if needed
 * 3. Repeat the process until no swaps are required
 * 
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */
public class BubbleSortStudentMarks {

    // Bubble Sort implementation
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if current element is greater than next
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swaps occurred, array is sorted
            if (!swapped) {
                System.out.println("Array sorted early at iteration " + (i + 1));
                break;
            }
        }
    }

    // Bubble Sort with step-by-step visualization
    public static void bubbleSortWithVisualization(int[] marks) {
        int n = marks.length;
        boolean swapped;

        System.out.println("Initial marks: " + Arrays.toString(marks));
        System.out.println("\nSorting process:");

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            System.out.println("\nPass " + (i + 1) + ":");

            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    System.out.printf("  Swapping %d and %d\n", marks[j], marks[j + 1]);
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("  After pass: " + Arrays.toString(marks));

            if (!swapped) {
                System.out.println("  No swaps - Array is sorted!");
                break;
            }
        }
    }

    // Calculate statistics
    private static void printStatistics(int[] marks) {
        int sum = 0;
        int min = marks[0];
        int max = marks[0];

        for (int mark : marks) {
            sum += mark;
            if (mark < min)
                min = mark;
            if (mark > max)
                max = mark;
        }

        double average = (double) sum / marks.length;

        System.out.println("\n=== Statistics ===");
        System.out.println("Total students: " + marks.length);
        System.out.println("Highest mark: " + max);
        System.out.println("Lowest mark: " + min);
        System.out.printf("Average mark: %.2f\n", average);
    }

    public static void main(String[] args) {
        System.out.println("=== Bubble Sort - Student Marks ===\n");

        // Test case 1 - Random marks
        int[] marks1 = { 78, 92, 45, 67, 88, 54, 73, 91, 62 };
        System.out.println("Test Case 1: Random student marks");
        System.out.println("Original: " + Arrays.toString(marks1));
        bubbleSort(marks1);
        System.out.println("Sorted:   " + Arrays.toString(marks1));
        printStatistics(marks1);

        System.out.println("\n" + "=".repeat(50));

        // Test case 2 - With visualization
        int[] marks2 = { 85, 72, 90, 65, 78 };
        System.out.println("\nTest Case 2: Sorting with visualization");
        bubbleSortWithVisualization(marks2);
        printStatistics(marks2);

        System.out.println("\n" + "=".repeat(50));

        // Test case 3 - Already sorted
        int[] marks3 = { 60, 70, 80, 90, 100 };
        System.out.println("\nTest Case 3: Already sorted marks");
        System.out.println("Original: " + Arrays.toString(marks3));
        bubbleSort(marks3);
        System.out.println("Sorted:   " + Arrays.toString(marks3));

        System.out.println("\n" + "=".repeat(50));

        // Test case 4 - Reverse sorted
        int[] marks4 = { 95, 85, 75, 65, 55, 45 };
        System.out.println("\nTest Case 4: Reverse sorted marks");
        System.out.println("Original: " + Arrays.toString(marks4));
        bubbleSort(marks4);
        System.out.println("Sorted:   " + Arrays.toString(marks4));

        System.out.println("\n" + "=".repeat(50));

        // Test case 5 - Duplicate marks
        int[] marks5 = { 80, 90, 80, 70, 90, 85 };
        System.out.println("\nTest Case 5: Marks with duplicates");
        System.out.println("Original: " + Arrays.toString(marks5));
        bubbleSort(marks5);
        System.out.println("Sorted:   " + Arrays.toString(marks5));
    }
}
