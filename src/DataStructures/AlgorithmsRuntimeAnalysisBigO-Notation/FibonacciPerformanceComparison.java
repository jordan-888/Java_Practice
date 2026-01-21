package DataStructures.AlgorithmsRuntimeAnalysisBigO_Notation;

/**
 * Problem 5: Recursive vs Iterative Fibonacci Computation
 * 
 * Objective:
 * Compare Recursive (O(2^n)) vs Iterative (O(N)) Fibonacci solutions.
 * 
 * Time Complexity:
 * - Recursive: O(2^n) - exponential growth
 * - Iterative: O(N) - linear growth
 * - Memoization: O(N) - with O(N) space
 */
public class FibonacciPerformanceComparison {

    // Recursive Fibonacci - O(2^n)
    public static long fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci - O(N)
    public static long fibonacciIterative(int n) {
        if (n <= 1)
            return n;

        long a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // Memoization Fibonacci - O(N)
    public static long fibonacciMemoization(int n) {
        long[] memo = new long[n + 1];
        return fibMemo(n, memo);
    }

    private static long fibMemo(int n, long[] memo) {
        if (n <= 1)
            return n;
        if (memo[n] != 0)
            return memo[n];

        memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        return memo[n];
    }

    // Benchmark function
    public static void benchmark(int n) {
        System.out.printf("Fibonacci(%d)%n", n);
        System.out.println("=".repeat(50));

        // Recursive (skip for large n)
        if (n <= 40) {
            long startTime = System.nanoTime();
            long result1 = fibonacciRecursive(n);
            long recursiveTime = System.nanoTime() - startTime;
            System.out.printf("Recursive:    %,d in %,d ns (%.3f ms)%n",
                    result1, recursiveTime, recursiveTime / 1_000_000.0);
        } else {
            System.out.println("Recursive:    Skipped (too slow, O(2^n) complexity)");
        }

        // Iterative
        long startTime = System.nanoTime();
        long result2 = fibonacciIterative(n);
        long iterativeTime = System.nanoTime() - startTime;
        System.out.printf("Iterative:    %,d in %,d ns (%.3f ms)%n",
                result2, iterativeTime, iterativeTime / 1_000_000.0);

        // Memoization
        startTime = System.nanoTime();
        long result3 = fibonacciMemoization(n);
        long memoTime = System.nanoTime() - startTime;
        System.out.printf("Memoization:  %,d in %,d ns (%.3f ms)%n",
                result3, memoTime, memoTime / 1_000_000.0);

        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Fibonacci Performance Comparison ===");
        System.out.println("Recursive: O(2^n) vs Iterative: O(N) vs Memoization: O(N)\n");

        int[] values = { 10, 20, 30, 40, 50 };

        for (int n : values) {
            benchmark(n);
        }

        System.out.println("Conclusion:");
        System.out.println("- Recursive approach is infeasible for n > 40 (exponential)");
        System.out.println("- Iterative approach is fast and memory-efficient");
        System.out.println("- Memoization trades space for time, similar to iterative");
        System.out.println("- Always prefer iterative or memoization for Fibonacci");
    }
}
