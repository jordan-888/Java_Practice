package datastructures.linearandbinarysearch;
import java.util.Arrays;

/**
 * Binary Search Problem 4: Find the First and Last Occurrence of an Element in
 * a Sorted Array
 * 
 * Problem:
 * Given a sorted array and a target element, write a program that uses Binary
 * Search
 * to find the first and last occurrence of the target element in the array.
 * If the element is not found, return -1.
 * 
 * Approach:
 * 1. Use binary search to find the first occurrence:
 * - Perform a regular binary search, but if the target is found, continue
 * searching
 * on the left side (right = mid - 1) to find the first occurrence
 * 2. Use binary search to find the last occurrence:
 * - Similar to finding the first occurrence, but once the target is found,
 * continue
 * searching on the right side (left = mid + 1) to find the last occurrence
 * 3. Return the indices of the first and last occurrence. If not found, return
 * -1
 */
public class FindFirstAndLastOccurrence {

    // Find first occurrence
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

    // Find last occurrence
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

    // Find first and last occurrence
    public static int[] findFirstAndLast(int[] arr, int target) {
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);
        return new int[] { first, last };
    }

    public static void main(String[] args) {
        System.out.println("=== Find First and Last Occurrence (Binary Search) ===\n");

        int[] sortedArray = { 5, 7, 7, 8, 8, 8, 10 };
        System.out.println("Array: " + Arrays.toString(sortedArray));
        System.out.println();

        int[] searchTargets = { 7, 8, 6, 10, 5 };

        System.out.println("Search Results:");
        System.out.println("=".repeat(50));
        for (int target : searchTargets) {
            int[] result = findFirstAndLast(sortedArray, target);
            if (result[0] != -1) {
                int count = result[1] - result[0] + 1;
                System.out.printf("Target %d:%n", target);
                System.out.printf("  First occurrence at index %d%n", result[0]);
                System.out.printf("  Last occurrence at index %d%n", result[1]);
                System.out.printf("  Total occurrences: %d%n", count);
            } else {
                System.out.printf("Target %d: Not found%n", target);
            }
            System.out.println();
        }
    }
}
