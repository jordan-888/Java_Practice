package datastructures.stacksqueueshashmapshashfunctions;
import java.util.HashMap;
import java.util.Arrays;

/**
 * Two Sum Problem
 * Problem: Given an array and a target sum, find two indices such that their
 * values add up to the target.
 * Approach: Use a hash map to store the index of each element as you iterate.
 * Check if target - current_element exists in the map.
 */
public class TwoSumProblem {

    // Find two indices that sum to target
    public static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(arr[i], i);
        }

        return new int[] {}; // No solution found
    }

    // Find all pairs of indices that sum to target
    public static void findAllTwoSums(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean found = false;

        System.out.println("\nAll index pairs with sum " + target + ":");

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            if (map.containsKey(complement)) {
                int j = map.get(complement);
                System.out.printf("  Indices [%d, %d]: arr[%d] + arr[%d] = %d + %d = %d\n",
                        j, i, j, i, arr[j], arr[i], target);
                found = true;
            }

            // Only store first occurrence to avoid duplicate pairs
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            }
        }

        if (!found) {
            System.out.println("  No pairs found");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Two Sum Problem ===\n");

        // Test case 1 - Solution exists
        int[] arr1 = { 2, 7, 11, 15 };
        int target1 = 9;
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Target: " + target1);
        int[] result1 = twoSum(arr1, target1);

        if (result1.length > 0) {
            System.out.printf("Indices: [%d, %d]\n", result1[0], result1[1]);
            System.out.printf("Values: arr[%d] + arr[%d] = %d + %d = %d\n",
                    result1[0], result1[1], arr1[result1[0]], arr1[result1[1]], target1);
        } else {
            System.out.println("No solution found");
        }

        System.out.println("\n" + "=".repeat(50));

        // Test case 2 - Multiple solutions
        int[] arr2 = { 3, 2, 4, 1, 5 };
        int target2 = 6;
        System.out.println("\nArray: " + Arrays.toString(arr2));
        System.out.println("Target: " + target2);
        findAllTwoSums(arr2, target2);

        System.out.println("\n" + "=".repeat(50));

        // Test case 3 - No solution
        int[] arr3 = { 1, 2, 3, 4 };
        int target3 = 10;
        System.out.println("\nArray: " + Arrays.toString(arr3));
        System.out.println("Target: " + target3);
        int[] result3 = twoSum(arr3, target3);

        if (result3.length > 0) {
            System.out.printf("Indices: [%d, %d]\n", result3[0], result3[1]);
        } else {
            System.out.println("No solution found");
        }

        System.out.println("\n" + "=".repeat(50));

        // Test case 4 - Negative numbers
        int[] arr4 = { -3, 4, 3, 90 };
        int target4 = 0;
        System.out.println("\nArray: " + Arrays.toString(arr4));
        System.out.println("Target: " + target4);
        int[] result4 = twoSum(arr4, target4);

        if (result4.length > 0) {
            System.out.printf("Indices: [%d, %d]\n", result4[0], result4[1]);
            System.out.printf("Values: arr[%d] + arr[%d] = %d + %d = %d\n",
                    result4[0], result4[1], arr4[result4[0]], arr4[result4[1]], target4);
        } else {
            System.out.println("No solution found");
        }

        System.out.println("\n" + "=".repeat(50));

        // Test case 5 - Duplicates
        int[] arr5 = { 3, 3, 2, 4 };
        int target5 = 6;
        System.out.println("\nArray: " + Arrays.toString(arr5));
        System.out.println("Target: " + target5);
        findAllTwoSums(arr5, target5);

        System.out.println("\n" + "=".repeat(50));

        // Test case 6 - Large numbers
        int[] arr6 = { 1000000, 500000, 250000, 750000 };
        int target6 = 1500000;
        System.out.println("\nArray: " + Arrays.toString(arr6));
        System.out.println("Target: " + target6);
        int[] result6 = twoSum(arr6, target6);

        if (result6.length > 0) {
            System.out.printf("Indices: [%d, %d]\n", result6[0], result6[1]);
            System.out.printf("Values: arr[%d] + arr[%d] = %d + %d = %d\n",
                    result6[0], result6[1], arr6[result6[0]], arr6[result6[1]], target6);
        } else {
            System.out.println("No solution found");
        }
    }
}
