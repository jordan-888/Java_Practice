package DataStructures.AlgorithmsRuntimeAnalysisBigO_Notation;

import java.util.Arrays;

/**
 * Problem 1: Search a Target in a Large Dataset
 * 
 * Objective:
 * Compare the performance of Linear Search (O(N)) and Binary Search (O(log N))
 * on different dataset sizes.
 * 
 * Time Complexity:
 * - Linear Search: O(N)
 * - Binary Search: O(log N) + O(N log N) for sorting
 */
public class SearchPerformanceComparison {

    // Linear Search - O(N)
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search - O(log N)
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

    // Benchmark function
    public static void benchmark(int size) {
        System.out.printf("Dataset Size: %,d%n", size);
        System.out.println("=".repeat(50));

        // Create array
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        int target = size - 1; // Worst case: search for last element

        // Linear Search
        long startTime = System.nanoTime();
        int result1 = linearSearch(arr, target);
        long linearTime = System.nanoTime() - startTime;

        // Binary Search (including sorting time)
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        startTime = System.nanoTime();
        Arrays.sort(arrCopy); // O(N log N)
        int result2 = binarySearch(arrCopy, target);
        long binaryTime = System.nanoTime() - startTime;

        System.out.printf("Linear Search:  %,d ns (%.3f ms)%n", linearTime, linearTime / 1_000_000.0);
        System.out.printf("Binary Search:  %,d ns (%.3f ms) [includes sorting]%n", binaryTime,
                binaryTime / 1_000_000.0);
        System.out.printf("Speedup: %.2fx faster%n", (double) linearTime / binaryTime);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Search Performance Comparison ===");
        System.out.println("Linear Search: O(N) vs Binary Search: O(log N)\n");

        int[] sizes = { 1_000, 10_000, 100_000, 1_000_000 };

        for (int size : sizes) {
            benchmark(size);
        }

        System.out.println("Conclusion:");
        System.out.println("- Linear Search is simple but slow for large datasets");
        System.out.println("- Binary Search is much faster but requires sorted data");
        System.out.println("- For repeated searches, sort once and use binary search");
    }
}
