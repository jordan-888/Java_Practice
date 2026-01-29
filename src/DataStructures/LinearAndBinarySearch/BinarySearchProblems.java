package datastructures.linearandbinarysearch;
import java.util.Arrays;

/**
 * Binary Search Problems
 * Problem 1: Find Rotation Point in Rotated Sorted Array
 * Problem 2: Find Peak Element in Array
 * Problem 3: Search in 2D Sorted Matrix
 * Problem 4: Find First and Last Occurrence of Element
 */
public class BinarySearchProblems {

    // Problem 1: Find Rotation Point in Rotated Sorted Array
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                // Minimum is in right half
                left = mid + 1;
            } else {
                // Minimum is in left half (including mid)
                right = mid;
            }
        }

        return left; // Index of smallest element (rotation point)
    }

    // Problem 2: Find Peak Element in Array
    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // Peak is in left half (including mid)
                right = mid;
            } else {
                // Peak is in right half
                left = mid + 1;
            }
        }

        return left; // Index of peak element
    }

    // Problem 3: Search in 2D Sorted Matrix
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
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    // Problem 4: Find First Occurrence
    private static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching left
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Problem 4: Find Last Occurrence
    private static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching right
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Problem 4: Find First and Last Occurrence
    public static int[] findFirstAndLast(int[] arr, int target) {
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);
        return new int[] { first, last };
    }

    public static void main(String[] args) {
        System.out.println("=== Binary Search Problems ===\n");

        // Problem 1: Find Rotation Point
        System.out.println("Problem 1: Find Rotation Point in Rotated Sorted Array\n");
        int[][] rotatedArrays = {
                { 4, 5, 6, 7, 0, 1, 2 },
                { 3, 4, 5, 1, 2 },
                { 2, 3, 4, 5, 6, 7, 8, 1 }
        };

        for (int[] arr : rotatedArrays) {
            System.out.println("Array: " + Arrays.toString(arr));
            int rotationPoint = findRotationPoint(arr);
            System.out.printf("Rotation point at index %d, value: %d%n", rotationPoint, arr[rotationPoint]);
            System.out.println();
        }

        System.out.println("=".repeat(50) + "\n");

        // Problem 2: Find Peak Element
        System.out.println("Problem 2: Find Peak Element in Array\n");
        int[][] peakArrays = {
                { 1, 2, 3, 1 },
                { 1, 2, 1, 3, 5, 6, 4 },
                { 1, 3, 20, 4, 1, 0 }
        };

        for (int[] arr : peakArrays) {
            System.out.println("Array: " + Arrays.toString(arr));
            int peakIndex = findPeakElement(arr);
            System.out.printf("Peak element at index %d, value: %d%n", peakIndex, arr[peakIndex]);
            System.out.println();
        }

        System.out.println("=".repeat(50) + "\n");

        // Problem 3: Search in 2D Matrix
        System.out.println("Problem 3: Search in 2D Sorted Matrix\n");
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

        int[] targets = { 3, 13, 60, 100 };
        for (int target : targets) {
            boolean found = searchMatrix(matrix, target);
            System.out.printf("Searching for %d: %s%n", target, found ? "Found" : "Not Found");
        }

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Problem 4: Find First and Last Occurrence
        System.out.println("Problem 4: Find First and Last Occurrence\n");
        int[] sortedArray = { 5, 7, 7, 8, 8, 8, 10 };
        System.out.println("Array: " + Arrays.toString(sortedArray));
        System.out.println();

        int[] searchTargets = { 7, 8, 6, 10 };
        for (int target : searchTargets) {
            int[] result = findFirstAndLast(sortedArray, target);
            if (result[0] != -1) {
                System.out.printf("Target %d: First occurrence at index %d, Last occurrence at index %d%n",
                        target, result[0], result[1]);
            } else {
                System.out.printf("Target %d: Not found%n", target);
            }
        }
    }
}
