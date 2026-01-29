package datastructures.stacksqueueshashmapshashfunctions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;

/**
 * Sliding Window Maximum
 * Problem: Given an array and a window size k, find the maximum element in each
 * sliding window of size k.
 * Approach: Use a deque (double-ended queue) to maintain indices of useful
 * elements in each window.
 */
public class SlidingWindowMaximum {

    // Find maximum in each sliding window of size k
    public static int[] maxSlidingWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // Store indices

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices whose corresponding values are smaller than current element
            // (they will never be maximum in any future window)
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            // Add current element index
            deque.offerLast(i);

            // The front of deque contains the index of maximum element for current window
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }

        return result;
    }

    // Print sliding window maximums
    private static void printSlidingWindowMax(int[] arr, int k, int[] result) {
        System.out.println("\nArray: " + Arrays.toString(arr));
        System.out.println("Window size: " + k);
        System.out.println("\nWindow\t\t\t\tMaximum");
        System.out.println("------\t\t\t\t-------");

        for (int i = 0; i < result.length; i++) {
            System.out.print("[");
            for (int j = i; j < i + k; j++) {
                System.out.print(arr[j]);
                if (j < i + k - 1)
                    System.out.print(", ");
            }
            System.out.printf("]\t\t\t%d\n", result[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Sliding Window Maximum ===\n");

        // Test case 1
        int[] arr1 = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k1 = 3;
        int[] result1 = maxSlidingWindow(arr1, k1);
        printSlidingWindowMax(arr1, k1, result1);

        System.out.println("\n" + "=".repeat(50));

        // Test case 2
        int[] arr2 = { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 };
        int k2 = 4;
        int[] result2 = maxSlidingWindow(arr2, k2);
        printSlidingWindowMax(arr2, k2, result2);

        System.out.println("\n" + "=".repeat(50));

        // Test case 3 - Small window
        int[] arr3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k3 = 2;
        int[] result3 = maxSlidingWindow(arr3, k3);
        printSlidingWindowMax(arr3, k3, result3);

        System.out.println("\n" + "=".repeat(50));

        // Test case 4 - Window size equals array length
        int[] arr4 = { 4, 1, 3, 5, 2 };
        int k4 = 5;
        int[] result4 = maxSlidingWindow(arr4, k4);
        System.out.println("\nArray: " + Arrays.toString(arr4));
        System.out.println("Window size: " + k4);
        System.out.println("Maximum: " + Arrays.toString(result4));
    }
}
