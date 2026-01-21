package DataStructures.StacksQueuesHashMapsHashFunctions;

import java.util.HashMap;
import java.util.Arrays;

/**
 * Check for a Pair with Given Sum in an Array
 * Problem: Given an array and a target sum, find if there exists a pair of
 * elements whose sum is equal to the target.
 * Approach: Store visited numbers in a hash map and check if target -
 * current_number exists in the map.
 */
public class PairWithGivenSum {

    // Check if pair exists with given sum
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            if (map.containsKey(complement)) {
                System.out.println("Pair found: (" + arr[i] + ", " + complement + ")");
                System.out.println("Indices: (" + i + ", " + map.get(complement) + ")");
                return true;
            }

            map.put(arr[i], i);
        }

        return false;
    }

    // Find all pairs with given sum
    public static void findAllPairsWithSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean found = false;

        System.out.println("\nAll pairs with sum " + target + ":");

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            if (map.containsKey(complement)) {
                System.out.println(
                        "  (" + arr[i] + ", " + complement + ") at indices (" + i + ", " + map.get(complement) + ")");
                found = true;
            }

            map.put(arr[i], i);
        }

        if (!found) {
            System.out.println("  No pairs found");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Check for Pair with Given Sum ===\n");

        // Test case 1 - Pair exists
        int[] arr1 = { 1, 4, 45, 6, 10, 8 };
        int target1 = 16;
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Target sum: " + target1);
        boolean result1 = hasPairWithSum(arr1, target1);
        System.out.println("Pair exists: " + result1);

        System.out.println("\n" + "=".repeat(50));

        // Test case 2 - Pair does not exist
        int[] arr2 = { 1, 2, 3, 4, 5 };
        int target2 = 20;
        System.out.println("\nArray: " + Arrays.toString(arr2));
        System.out.println("Target sum: " + target2);
        boolean result2 = hasPairWithSum(arr2, target2);
        System.out.println("Pair exists: " + result2);

        System.out.println("\n" + "=".repeat(50));

        // Test case 3 - Multiple pairs exist
        int[] arr3 = { 1, 5, 7, -1, 5 };
        int target3 = 6;
        System.out.println("\nArray: " + Arrays.toString(arr3));
        System.out.println("Target sum: " + target3);
        findAllPairsWithSum(arr3, target3);

        System.out.println("\n" + "=".repeat(50));

        // Test case 4 - Negative numbers
        int[] arr4 = { -5, -2, 3, 7, 10 };
        int target4 = 5;
        System.out.println("\nArray: " + Arrays.toString(arr4));
        System.out.println("Target sum: " + target4);
        findAllPairsWithSum(arr4, target4);

        System.out.println("\n" + "=".repeat(50));

        // Test case 5 - Zero sum
        int[] arr5 = { -3, 0, 3, 4, -1 };
        int target5 = 0;
        System.out.println("\nArray: " + Arrays.toString(arr5));
        System.out.println("Target sum: " + target5);
        findAllPairsWithSum(arr5, target5);
    }
}
