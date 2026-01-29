package datastructures.linearandbinarysearch;
/**
 * StringBuffer Problem 2: Compare StringBuffer with StringBuilder for String
 * Concatenation
 * 
 * Problem:
 * Write a program that compares the performance of StringBuffer and
 * StringBuilder
 * for concatenating strings. For large datasets (e.g., concatenating 1 million
 * strings),
 * compare the execution time of both classes.
 * 
 * Approach:
 * 1. Initialize two StringBuffer and StringBuilder objects
 * 2. Perform string concatenation in both objects, appending 1 million strings
 * (e.g., "hello")
 * 3. Measure the time taken to complete the concatenation using
 * System.nanoTime()
 * 4. Output the time taken by both classes for comparison
 */
public class CompareStringBufferAndStringBuilder {

    public static void comparePerformance(int iterations) {
        System.out.println("Comparing StringBuffer vs StringBuilder");
        System.out.printf("Iterations: %,d%n", iterations);
        System.out.println();

        // Test StringBuffer
        long startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append("hello");
        }
        long stringBufferTime = System.nanoTime() - startTime;

        // Test StringBuilder
        startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("hello");
        }
        long stringBuilderTime = System.nanoTime() - startTime;

        // Display results
        System.out.printf("StringBuffer time:  %,d ns (%.2f ms)%n",
                stringBufferTime, stringBufferTime / 1_000_000.0);
        System.out.printf("StringBuilder time: %,d ns (%.2f ms)%n",
                stringBuilderTime, stringBuilderTime / 1_000_000.0);
        System.out.printf("StringBuilder is %.2fx faster%n",
                (double) stringBufferTime / stringBuilderTime);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Compare StringBuffer and StringBuilder Performance ===\n");

        // Test with different iteration counts
        int[] testSizes = { 10_000, 100_000, 1_000_000 };

        for (int size : testSizes) {
            comparePerformance(size);
            System.out.println("=".repeat(50));
            System.out.println();
        }
    }
}
