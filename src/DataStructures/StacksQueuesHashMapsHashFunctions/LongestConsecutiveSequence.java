package datastructures.stacksqueueshashmapshashfunctions;
import java.util.HashSet;
import java.util.Arrays;

/**
 * Longest Consecutive Sequence
 * Problem: Given an unsorted array, find the length of the longest consecutive
 * elements sequence.
 * Approach: Use a hash set to store elements and check for consecutive elements
 * efficiently.
 */
public class LongestConsecutiveSequence {

    // Find length of longest consecutive sequence
    public static int longestConsecutive(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        // Add all elements to hash set
        for (int num : arr) {
            set.add(num);
        }

        int maxLength = 0;

        for (int num : arr) {
            // Only start counting if this is the beginning of a sequence
            // (i.e., num-1 is not in the set)
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    // Find and print the longest consecutive sequence
    public static void findLongestSequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Empty array");
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int maxLength = 0;
        int sequenceStart = 0;

        for (int num : arr) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    sequenceStart = num;
                }
            }
        }

        // Print the sequence
        System.out.print("Longest consecutive sequence: [");
        for (int i = 0; i < maxLength; i++) {
            System.out.print(sequenceStart + i);
            if (i < maxLength - 1)
                System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Length: " + maxLength);
    }

    public static void main(String[] args) {
        System.out.println("=== Longest Consecutive Sequence ===\n");

        // Test case 1
        int[] arr1 = { 100, 4, 200, 1, 3, 2 };
        System.out.println("Array: " + Arrays.toString(arr1));
        findLongestSequence(arr1);
        System.out.println();

        System.out.println("=".repeat(50));

        // Test case 2
        int[] arr2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println("\nArray: " + Arrays.toString(arr2));
        findLongestSequence(arr2);
        System.out.println();

        System.out.println("=".repeat(50));

        // Test case 3 - No consecutive sequence
        int[] arr3 = { 1, 9, 3, 10, 4, 20, 2 };
        System.out.println("\nArray: " + Arrays.toString(arr3));
        findLongestSequence(arr3);
        System.out.println();

        System.out.println("=".repeat(50));

        // Test case 4 - Negative numbers
        int[] arr4 = { -2, -1, 0, 1, 2, 3 };
        System.out.println("\nArray: " + Arrays.toString(arr4));
        findLongestSequence(arr4);
        System.out.println();

        System.out.println("=".repeat(50));

        // Test case 5 - Duplicates
        int[] arr5 = { 1, 2, 0, 1, 2, 3, 4, 5 };
        System.out.println("\nArray: " + Arrays.toString(arr5));
        findLongestSequence(arr5);
        System.out.println();

        System.out.println("=".repeat(50));

        // Test case 6 - Single element
        int[] arr6 = { 5 };
        System.out.println("\nArray: " + Arrays.toString(arr6));
        findLongestSequence(arr6);
    }
}
