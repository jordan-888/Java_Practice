package datastructures.linearandbinarysearch;
import java.util.Arrays;

/**
 * Binary Search Problem 1: Find the Rotation Point in a Rotated Sorted Array
 * 
 * Problem:
 * You are given a rotated sorted array. Write a program that performs Binary
 * Search
 * to find the index of the smallest element in the array (the rotation point).
 * 
 * Approach:
 * 1. Initialize left as 0 and right as n - 1
 * 2. Perform a binary search:
 * - Find the middle element mid = left + (right - left) / 2
 * - If arr[mid] > arr[right], then the smallest element is in the right half,
 * so update left = mid + 1
 * - If arr[mid] < arr[right], the smallest element is in the left half, so
 * update right = mid
 * 3. Continue until left equals right, and then return arr[left] (the rotation
 * point)
 */
public class FindRotationPointInRotatedArray {

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

    public static void main(String[] args) {
        System.out.println("=== Find Rotation Point in Rotated Sorted Array (Binary Search) ===\n");

        int[][] rotatedArrays = {
                { 4, 5, 6, 7, 0, 1, 2 },
                { 3, 4, 5, 1, 2 },
                { 2, 3, 4, 5, 6, 7, 8, 1 },
                { 11, 13, 15, 17, 3, 5, 7, 9 },
                { 1, 2, 3, 4, 5 } // Not rotated
        };

        for (int[] arr : rotatedArrays) {
            System.out.println("Array: " + Arrays.toString(arr));
            int rotationPoint = findRotationPoint(arr);
            System.out.printf("Rotation point at index %d, value: %d%n", rotationPoint, arr[rotationPoint]);
            System.out.println();
        }
    }
}
