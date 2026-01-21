package DataStructures.StacksQueuesHashMapsHashFunctions;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Find All Subarrays with Zero Sum
 * Problem: Given an array, find all subarrays whose elements sum up to zero.
 * Approach: Use a hash map to store the cumulative sum and its indices.
 * If a sum repeats, a zero-sum subarray exists between those indices.
 */
public class ZeroSumSubarrays {

    // Find all subarrays with zero sum
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> sumMap = new HashMap<>();
        int sum = 0;

        // Add initial sum 0 at index -1 (for subarrays starting from index 0)
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If this sum has been seen before, we found zero-sum subarrays
            if (sumMap.containsKey(sum)) {
                ArrayList<Integer> indices = sumMap.get(sum);
                for (int startIndex : indices) {
                    result.add(new int[] { startIndex + 1, i });
                }
            }

            // Add current sum and index to map
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        return result;
    }

    // Print subarray
    private static void printSubarray(int[] arr, int start, int end) {
        System.out.print("[");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i]);
            if (i < end)
                System.out.print(", ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        System.out.println("=== Find All Subarrays with Zero Sum ===\n");

        // Test case 1
        int[] arr1 = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
        System.out.println("Array: " + Arrays.toString(arr1));
        List<int[]> result1 = findZeroSumSubarrays(arr1);

        if (result1.isEmpty()) {
            System.out.println("No zero-sum subarrays found");
        } else {
            System.out.println("\nZero-sum subarrays found:");
            for (int[] range : result1) {
                System.out.print("Index [" + range[0] + ", " + range[1] + "]: ");
                printSubarray(arr1, range[0], range[1]);
                System.out.println();
            }
        }

        System.out.println("\n" + "=".repeat(50));

        // Test case 2
        int[] arr2 = { 4, 2, -3, 1, 6 };
        System.out.println("\nArray: " + Arrays.toString(arr2));
        List<int[]> result2 = findZeroSumSubarrays(arr2);

        if (result2.isEmpty()) {
            System.out.println("No zero-sum subarrays found");
        } else {
            System.out.println("\nZero-sum subarrays found:");
            for (int[] range : result2) {
                System.out.print("Index [" + range[0] + ", " + range[1] + "]: ");
                printSubarray(arr2, range[0], range[1]);
                System.out.println();
            }
        }

        System.out.println("\n" + "=".repeat(50));

        // Test case 3 - Multiple zero-sum subarrays
        int[] arr3 = { 0, 0, 5, 5, 0, 0 };
        System.out.println("\nArray: " + Arrays.toString(arr3));
        List<int[]> result3 = findZeroSumSubarrays(arr3);

        if (result3.isEmpty()) {
            System.out.println("No zero-sum subarrays found");
        } else {
            System.out.println("\nZero-sum subarrays found:");
            for (int[] range : result3) {
                System.out.print("Index [" + range[0] + ", " + range[1] + "]: ");
                printSubarray(arr3, range[0], range[1]);
                System.out.println();
            }
        }

        System.out.println("\n" + "=".repeat(50));

        // Test case 4 - Entire array sums to zero
        int[] arr4 = { 1, 2, -3 };
        System.out.println("\nArray: " + Arrays.toString(arr4));
        List<int[]> result4 = findZeroSumSubarrays(arr4);

        if (result4.isEmpty()) {
            System.out.println("No zero-sum subarrays found");
        } else {
            System.out.println("\nZero-sum subarrays found:");
            for (int[] range : result4) {
                System.out.print("Index [" + range[0] + ", " + range[1] + "]: ");
                printSubarray(arr4, range[0], range[1]);
                System.out.println();
            }
        }
    }
}
