package datastructures.linearandbinarysearch;
import java.util.Arrays;

/**
 * Challenge Problem: Linear Search for First Missing Positive + Binary Search
 * for Target
 * 
 * Problem:
 * You are given a list of integers. Write a program that uses Linear Search to
 * find
 * the first missing positive integer in the list and Binary Search to find the
 * index
 * of a given target number.
 * 
 * Approach:
 * Linear Search for the first missing positive integer:
 * - Iterate through the list and mark each number in the list as visited
 * (you can use negative marking or a separate array)
 * - Traverse the array again to find the first positive integer that is not
 * marked
 * 
 * Binary Search for the target index:
 * - After sorting the array, perform binary search to find the index of the
 * given target number
 * - Return the index if found, otherwise return -1
 */
public class LinearAndBinarySearchChallenge {

    // Linear Search: Find first missing positive
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        int[] copy = Arrays.copyOf(arr, n);

        // Replace negative numbers and zeros with n+1
        for (int i = 0; i < n; i++) {
            if (copy[i] <= 0) {
                copy[i] = n + 1;
            }
        }

        // Mark presence of numbers by making values negative
        for (int i = 0; i < n; i++) {
            int num = Math.abs(copy[i]);
            if (num <= n) {
                copy[num - 1] = -Math.abs(copy[num - 1]);
            }
        }

        // Find first positive index
        for (int i = 0; i < n; i++) {
            if (copy[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    // Binary Search: Find target index
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("=== Challenge: Linear + Binary Search ===\n");

        int[] testArray = { 3, 4, -1, 1, 7, 2, 9 };
        System.out.println("Original array: " + Arrays.toString(testArray));
        System.out.println();

        // Part 1: Linear Search for first missing positive
        System.out.println("Part 1: Linear Search for First Missing Positive");
        System.out.println("=".repeat(50));
        int missingPositive = findFirstMissingPositive(testArray);
        System.out.println("First missing positive integer: " + missingPositive);
        System.out.println();

        // Part 2: Binary Search for target
        System.out.println("Part 2: Binary Search for Target Index");
        System.out.println("=".repeat(50));

        int[] sortedArray = Arrays.copyOf(testArray, testArray.length);
        Arrays.sort(sortedArray);
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
        System.out.println();

        int[] targets = { 1, 7, 5, 10, -1, 9 };
        for (int target : targets) {
            int index = binarySearch(sortedArray, target);
            if (index != -1) {
                System.out.printf("Target %d found at index %d%n", target, index);
            } else {
                System.out.printf("Target %d not found%n", target);
            }
        }
    }
}
