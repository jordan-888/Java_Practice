package datastructures.linearandbinarysearch;
/**
 * StringBuffer Problems
 * Problem 1: Concatenate Strings Efficiently
 * Problem 2: Compare StringBuffer vs StringBuilder Performance
 */
public class StringBufferProblems {

    // Problem 1: Concatenate Strings Efficiently Using StringBuffer
    public static String concatenateStrings(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    // Problem 2: Compare StringBuffer vs StringBuilder Performance
    public static void comparePerformance(int iterations) {
        System.out.println("Comparing StringBuffer vs StringBuilder");
        System.out.println("Iterations: " + iterations);
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
    }

    public static void main(String[] args) {
        System.out.println("=== StringBuffer Problems ===\n");

        // Problem 1: Concatenate Strings
        System.out.println("Problem 1: Concatenate Strings Efficiently");
        String[] words = { "Java", " ", "is", " ", "awesome", "!" };
        System.out.println("Input array: " + java.util.Arrays.toString(words));
        System.out.println("Concatenated: \"" + concatenateStrings(words) + "\"");
        System.out.println();

        System.out.println("=".repeat(50) + "\n");

        // Problem 2: Performance Comparison
        System.out.println("Problem 2: Performance Comparison\n");

        // Test with different iteration counts
        int[] testSizes = { 10_000, 100_000, 1_000_000 };

        for (int size : testSizes) {
            comparePerformance(size);
            System.out.println();
        }
    }
}
