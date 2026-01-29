package datastructures.linearandbinarysearch;
import java.util.Arrays;

/**
 * Binary Search Problem 3: Search for a Target Value in a 2D Sorted Matrix
 * 
 * Problem:
 * You are given a 2D matrix where each row is sorted in ascending order, and
 * the first
 * element of each row is greater than the last element of the previous row.
 * Write a program
 * that performs Binary Search to find a target value in the matrix. If the
 * value is found,
 * return true. Otherwise, return false.
 * 
 * Approach:
 * 1. Treat the matrix as a 1D array (flattened version)
 * 2. Initialize left as 0 and right as rows * columns - 1
 * 3. Perform binary search:
 * - Find the middle element index mid = left + (right - left) / 2
 * - Convert mid to row and column indices using row = mid / numColumns and col
 * = mid % numColumns
 * - Compare the middle element with the target:
 * - If it matches, return true
 * - If the target is smaller, search the left half by updating right = mid - 1
 * - If the target is larger, search the right half by updating left = mid + 1
 * 4. If the element is not found, return false
 */
public class SearchIn2DSortedMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int midValue = matrix[row][col];

            if (midValue == target) {
                System.out.printf("Found %d at position [%d][%d]%n", target, row, col);
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("=== Search in 2D Sorted Matrix (Binary Search) ===\n");

        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };

        System.out.println("Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();

        int[] targets = { 3, 13, 60, 100, 1, 34 };

        System.out.println("Search Results:");
        System.out.println("=".repeat(50));
        for (int target : targets) {
            System.out.print("Searching for " + target + ": ");
            boolean found = searchMatrix(matrix, target);
            if (!found) {
                System.out.println("Not Found");
            }
            System.out.println();
        }
    }
}
