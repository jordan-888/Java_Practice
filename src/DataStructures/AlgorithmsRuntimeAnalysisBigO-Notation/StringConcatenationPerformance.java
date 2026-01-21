package DataStructures.AlgorithmsRuntimeAnalysisBigO_Notation;

/**
 * Problem 3: String Concatenation Performance
 * 
 * Objective:
 * Compare the performance of String (O(N²)), StringBuilder (O(N)),
 * and StringBuffer (O(N)) when concatenating strings.
 * 
 * Time Complexity:
 * - String: O(N²) - creates new object each time
 * - StringBuilder: O(N) - mutable, thread-unsafe
 * - StringBuffer: O(N) - mutable, thread-safe
 */
public class StringConcatenationPerformance {

    // Using String - O(N²)
    public static String concatenateWithString(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += "hello";
        }
        return result;
    }

    // Using StringBuilder - O(N)
    public static String concatenateWithStringBuilder(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("hello");
        }
        return sb.toString();
    }

    // Using StringBuffer - O(N)
    public static String concatenateWithStringBuffer(int count) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append("hello");
        }
        return sb.toString();
    }

    // Benchmark function
    public static void benchmark(int count) {
        System.out.printf("Operations Count: %,d%n", count);
        System.out.println("=".repeat(50));

        // String concatenation
        if (count <= 10_000) { // Skip for large counts
            long startTime = System.nanoTime();
            concatenateWithString(count);
            long stringTime = System.nanoTime() - startTime;
            System.out.printf("String:        %,d ns (%.3f ms)%n", stringTime, stringTime / 1_000_000.0);
        } else {
            System.out.println("String:        Skipped (too slow, O(N²) complexity)");
        }

        // StringBuilder
        long startTime = System.nanoTime();
        concatenateWithStringBuilder(count);
        long stringBuilderTime = System.nanoTime() - startTime;
        System.out.printf("StringBuilder: %,d ns (%.3f ms)%n", stringBuilderTime, stringBuilderTime / 1_000_000.0);

        // StringBuffer
        startTime = System.nanoTime();
        concatenateWithStringBuffer(count);
        long stringBufferTime = System.nanoTime() - startTime;
        System.out.printf("StringBuffer:  %,d ns (%.3f ms)%n", stringBufferTime, stringBufferTime / 1_000_000.0);

        System.out.printf("StringBuilder is %.2fx faster than StringBuffer%n",
                (double) stringBufferTime / stringBuilderTime);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== String Concatenation Performance ===");
        System.out.println("String: O(N²) vs StringBuilder: O(N) vs StringBuffer: O(N)\n");

        int[] counts = { 1_000, 10_000, 100_000, 1_000_000 };

        for (int count : counts) {
            benchmark(count);
        }

        System.out.println("Conclusion:");
        System.out.println("- String concatenation is extremely slow (O(N²))");
        System.out.println("- StringBuilder is fastest for single-threaded operations");
        System.out.println("- StringBuffer adds thread-safety overhead (~50% slower)");
        System.out.println("- Always use StringBuilder/StringBuffer for loops");
    }
}
