package datastructures.algorithmsruntimeanalysisbigonotation;
import java.util.Arrays;
import java.util.Random;

/**
 * Problem 2: Sorting Large Data Efficiently
 * 
 * Objective:
 * Compare sorting algorithms: Bubble Sort (O(N²)), Merge Sort (O(N log N)),
 * and Quick Sort (O(N log N)).
 * 
 * Time Complexity:
 * - Bubble Sort: O(N²)
 * - Merge Sort: O(N log N)
 * - Quick Sort: O(N log N) average, O(N²) worst case
 */
public class SortingPerformanceComparison {

    // Bubble Sort - O(N²)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort - O(N log N)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
    }

    // Quick Sort - O(N log N)
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Generate random array
    private static int[] generateRandomArray(int size) {
        Random rand = new Random(42); // Fixed seed for consistency
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size);
        }
        return arr;
    }

    // Benchmark function
    public static void benchmark(int size) {
        System.out.printf("Dataset Size: %,d%n", size);
        System.out.println("=".repeat(50));

        // Bubble Sort
        if (size <= 10_000) { // Skip for large sizes
            int[] arr1 = generateRandomArray(size);
            long startTime = System.nanoTime();
            bubbleSort(arr1);
            long bubbleTime = System.nanoTime() - startTime;
            System.out.printf("Bubble Sort:  %,d ns (%.3f ms)%n", bubbleTime, bubbleTime / 1_000_000.0);
        } else {
            System.out.println("Bubble Sort:  Skipped (too slow for large datasets)");
        }

        // Merge Sort
        int[] arr2 = generateRandomArray(size);
        long startTime = System.nanoTime();
        mergeSort(arr2, 0, arr2.length - 1);
        long mergeTime = System.nanoTime() - startTime;
        System.out.printf("Merge Sort:   %,d ns (%.3f ms)%n", mergeTime, mergeTime / 1_000_000.0);

        // Quick Sort
        int[] arr3 = generateRandomArray(size);
        startTime = System.nanoTime();
        quickSort(arr3, 0, arr3.length - 1);
        long quickTime = System.nanoTime() - startTime;
        System.out.printf("Quick Sort:   %,d ns (%.3f ms)%n", quickTime, quickTime / 1_000_000.0);

        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Sorting Performance Comparison ===");
        System.out.println("Bubble Sort: O(N²) vs Merge Sort: O(N log N) vs Quick Sort: O(N log N)\n");

        int[] sizes = { 1_000, 10_000, 100_000 };

        for (int size : sizes) {
            benchmark(size);
        }

        System.out.println("Conclusion:");
        System.out.println("- Bubble Sort is impractical for large datasets (O(N²))");
        System.out.println("- Merge Sort is stable and consistently O(N log N)");
        System.out.println("- Quick Sort is fastest on average but can degrade to O(N²)");
    }
}
