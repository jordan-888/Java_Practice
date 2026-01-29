package datastructures.algorithmsruntimeanalysisbigonotation;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Random;

/**
 * Problem 6: Comparing Different Data Structures for Searching
 * 
 * Objective:
 * Compare Array (O(N)), HashSet (O(1)), and TreeSet (O(log N)) for searching
 * elements.
 * 
 * Time Complexity:
 * - Array: O(N) - linear search
 * - HashSet: O(1) - hash-based lookup
 * - TreeSet: O(log N) - balanced BST
 */
public class DataStructureSearchComparison {

    // Search in Array - O(N)
    public static boolean searchInArray(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    // Benchmark function
    public static void benchmark(int size) {
        System.out.printf("Dataset Size: %,d%n", size);
        System.out.println("=".repeat(50));

        Random rand = new Random(42); // Fixed seed for consistency

        // Prepare data structures
        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            int value = rand.nextInt(size);
            array[i] = value;
            hashSet.add(value);
            treeSet.add(value);
        }

        // Search for elements (worst case: not in collection)
        int searchCount = 1000;
        int[] searchTargets = new int[searchCount];
        for (int i = 0; i < searchCount; i++) {
            searchTargets[i] = rand.nextInt(size * 2); // Some won't exist
        }

        // Array search
        long startTime = System.nanoTime();
        int foundCount1 = 0;
        for (int target : searchTargets) {
            if (searchInArray(array, target)) {
                foundCount1++;
            }
        }
        long arrayTime = System.nanoTime() - startTime;

        // HashSet search
        startTime = System.nanoTime();
        int foundCount2 = 0;
        for (int target : searchTargets) {
            if (hashSet.contains(target)) {
                foundCount2++;
            }
        }
        long hashSetTime = System.nanoTime() - startTime;

        // TreeSet search
        startTime = System.nanoTime();
        int foundCount3 = 0;
        for (int target : searchTargets) {
            if (treeSet.contains(target)) {
                foundCount3++;
            }
        }
        long treeSetTime = System.nanoTime() - startTime;

        System.out.printf("Array Search:   %,d ns (%.3f ms) - %d found%n",
                arrayTime, arrayTime / 1_000_000.0, foundCount1);
        System.out.printf("HashSet Search: %,d ns (%.3f ms) - %d found%n",
                hashSetTime, hashSetTime / 1_000_000.0, foundCount2);
        System.out.printf("TreeSet Search: %,d ns (%.3f ms) - %d found%n",
                treeSetTime, treeSetTime / 1_000_000.0, foundCount3);

        System.out.printf("HashSet is %.2fx faster than Array%n", (double) arrayTime / hashSetTime);
        System.out.printf("HashSet is %.2fx faster than TreeSet%n", (double) treeSetTime / hashSetTime);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Data Structure Search Performance Comparison ===");
        System.out.println("Array: O(N) vs HashSet: O(1) vs TreeSet: O(log N)\n");

        int[] sizes = { 1_000, 10_000, 100_000, 1_000_000 };

        for (int size : sizes) {
            benchmark(size);
        }

        System.out.println("Conclusion:");
        System.out.println("- HashSet is fastest for lookups (O(1) average)");
        System.out.println("- TreeSet maintains order but slower than HashSet (O(log N))");
        System.out.println("- Array search is slowest for large datasets (O(N))");
        System.out.println("- Use HashSet when order doesn't matter");
        System.out.println("- Use TreeSet when you need sorted data");
    }
}
