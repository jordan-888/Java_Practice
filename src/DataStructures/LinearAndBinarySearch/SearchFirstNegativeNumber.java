package datastructures.linearandbinarysearch;
import java.util.Arrays;

/**
 * Linear Search Problem 1: Search for the First Negative Number
 * 
 * Problem:
 * You are given an integer array. Write a program that performs Linear Search
 * to find the first negative number in the array. If a negative number is
 * found,
 * return its index. If no negative number is found, return -1.
 * 
 * Approach:
 * 1. Iterate through the array from the start
 * 2. Check if the current element is negative
 * 3. If a negative number is found, return its index
 * 4. If the loop completes without finding a negative number, return -1
 */
public class SearchFirstNegativeNumber {

    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i; // Return index of first negative number
            }
        }
        return -1; // No negative number found
    }

    public static void main(String[] args) {
        System.out.println("=== Search for First Negative Number (Linear Search) ===\n");

        int[][] testArrays = {
                { 5, 12, -3, 8, -1, 20 },
                { 10, 20, 30, 40, 50 },
                { -5, -10, -15 },
                { 0, 0, 0, -1 },
                { 100, 50, 25, 12, 6, 3, 1 },
                { -100, 200, -50, 75 }
        };

        for (int[] arr : testArrays) {
            System.out.println("Array: " + Arrays.toString(arr));
            int index = findFirstNegative(arr);
            if (index != -1) {
                System.out.printf("First negative number: %d at index %d%n", arr[index], index);
            } else {
                System.out.println("No negative number found");
            }
            System.out.println();
        }
    }
}
