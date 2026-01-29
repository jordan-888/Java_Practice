package datastructures.linearandbinarysearch;
import java.util.Arrays;

/**
 * Binary Search Problem 2: Find the Peak Element in an Array
 * 
 * Problem:
 * A peak element is an element that is greater than its neighbors. Write a
 * program
 * that performs Binary Search to find a peak element in an array. If there are
 * multiple peak elements, return any one of them.
 * 
 * Approach:
 * 1. Initialize left as 0 and right as n - 1
 * 2. Perform a binary search:
 * - Find the middle element mid = left + (right - left) / 2
 * - If arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1], arr[mid] is a peak
 * element
 * - If arr[mid] < arr[mid - 1], then search the left half, updating right = mid
 * - 1
 * - If arr[mid] < arr[mid + 1], then search the right half, updating left = mid
 * + 1
 * 3. Continue until a peak element is found
 */
public class FindPeakElementInArray {

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

    public static void main(String[] args) {
        System.out.println("=== Find Peak Element in Array (Binary Search) ===\n");

        int[][] peakArrays = {
                { 1, 2, 3, 1 },
                { 1, 2, 1, 3, 5, 6, 4 },
                { 1, 3, 20, 4, 1, 0 },
                { 5, 10, 20, 15 },
                { 10, 20, 30, 40, 50 } // Increasing array
        };

        for (int[] arr : peakArrays) {
            System.out.println("Array: " + Arrays.toString(arr));
            int peakIndex = findPeakElement(arr);
            System.out.printf("Peak element at index %d, value: %d%n", peakIndex, arr[peakIndex]);

            // Verify it's a peak
            boolean isPeak = true;
            if (peakIndex > 0 && arr[peakIndex] <= arr[peakIndex - 1])
                isPeak = false;
            if (peakIndex < arr.length - 1 && arr[peakIndex] <= arr[peakIndex + 1])
                isPeak = false;
            System.out.println("Verified as peak: " + isPeak);
            System.out.println();
        }
    }
}
